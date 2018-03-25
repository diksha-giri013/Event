package fgc.amitech;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static fgc.amitech.EventDetails.makeBOAData;
import static fgc.amitech.EventDetails.makeCultData;
import static fgc.amitech.EventDetails.makeEventData;
import static fgc.amitech.EventDetails.makeFunData;
import static fgc.amitech.EventDetails.makeLitData;
import static fgc.amitech.EventDetails.makeSponData;
import static fgc.amitech.EventDetails.makeTechData;

public class MainActivity extends AppCompatActivity {
    private LinearLayoutManager layoutManager;
    private RecyclerView.ViewHolder viewHolder;
    List<event> eventList;

    String change_text[] = {"is here", "have fun!!", "it is fun!!", "Let's explore", "let's do it", "Let's participate"};
    private TextSwitcher mSwitcher;
    private int mCounter = 0;
    private static int SPLASH_TIME_OUT = 3000;
    private Handler handler = new Handler();

    // Define the code block to be executed
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            // Insert custom code here
            Random rand = new Random();
            int mCounter = rand.nextInt(6);
            mSwitcher.setText(change_text[mCounter]);
            // Repeat every 2 seconds
            handler.postDelayed(runnable, SPLASH_TIME_OUT);
        }
    };

// Start the Runnable immediately

    //Start Event card variables
    private RecyclerView dash_rv_eventCard;
    private eventCardAdapter cardAdapter;
    private ArrayList<EventDetails> eventCard = new ArrayList<EventDetails>();

    //--finish--

    //Start Event category variables
    private RecyclerView dash_rv_eventCategory;
    private eventCardCategoryAdapter categoryAdapter;
    private String[] eventCat;
    private static String selectedCat="BEST OF AMITECH";
    private static TextView dashHeader;
    private PrefManager prefManager;
    //finish
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mSwitcher = (TextSwitcher) findViewById(R.id.switcher);
//ContentAdapter adapter=new ContentAdapter(rv.getContext(),eventList);
        mSwitcher.setFactory(mFactory);
        Animation in = AnimationUtils.loadAnimation(this,
                android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this,
                android.R.anim.slide_out_right);
        mSwitcher.setInAnimation(in);
        mSwitcher.setOutAnimation(out);
        mSwitcher.setCurrentText("is here");
        handler.post(runnable);

        dashHeader = (TextView) findViewById(R.id.dash_tv_cat_title);
        dashHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefManager = new PrefManager(MainActivity.this);
                prefManager.setFirstTimeLaunch(true);
            }
        });

        //Creating the data set for the event card
        switch (selectedCat){
            case "ALL EVENTS":
                eventCard = makeEventData();
                break;
            case "BEST OF AMITECH":
                eventCard = makeBOAData();
                break;
            case "FUN":
                eventCard = makeFunData();
                break;
            case "CULTURAL":
                eventCard = makeCultData();
                break;
            case "SPONSORED":
                eventCard = makeSponData();
                break;
            case "LITERARY":
                eventCard = makeLitData();
                break;
            case "TECHNICAL":
                eventCard = makeTechData();
                break;
            default:
                eventCard = makeBOAData();
                break;
        }
        LinearLayoutManager layoutManager_rv = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        dash_rv_eventCard = (RecyclerView) findViewById(R.id.dash_rv_eventcard);
        dash_rv_eventCard.setLayoutManager(layoutManager_rv);
        cardAdapter = new eventCardAdapter(this, eventCard);
        dash_rv_eventCard.setAdapter(cardAdapter);

        eventCat = new String []{
                "BEST OF AMITECH",
                "ALL EVENTS",
                "FAVORITE",
                "TECHNICAL",
                "CULTURAL",
                "FUN",
                "LITERARY",
                "SPONSORED"
        };
        LinearLayoutManager layoutManager_rv_cat = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        dash_rv_eventCategory = (RecyclerView) findViewById(R.id.dash_rv_catlist);
        dash_rv_eventCategory.setLayoutManager(layoutManager_rv_cat);
        categoryAdapter = new eventCardCategoryAdapter(this, eventCat);
        dash_rv_eventCategory.setAdapter(categoryAdapter);

        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RecyclerView rv=(RecyclerView)findViewById(R.id.mainRecycle);
        rv.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);*/
//ContentAdapter adapter=new ContentAdapter(rv.getContext(),eventList);
    }

    private ViewSwitcher.ViewFactory mFactory = new ViewSwitcher.ViewFactory() {


        @Override
        public View makeView() {

            // Create a new TextView
            TextView t = new TextView(MainActivity.this);
            t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
/*            t.setTypeface(Typeface.defaultFromStyle(R.font.oxygen_light));*/
            //t.setTextAppearance(MainActivity.this,R.font.chewy);
            t.setTextAppearance(MainActivity.this, R.style.CustomText);

            return t;
        }
    };

    //public ArrayList<EventDetails> getCardData() { return eventCard; }

    class eventCardAdapter extends RecyclerView.Adapter<eventCardAdapter.ViewHolder> {
        private ArrayList<EventDetails> meventCard;
        private Context mcontext;
        //private String selectedCat = "BEST OF AMITECH";

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            public TextView cardTitle;
            public TextView cardDesc;
            public Button bt_details;
            public Button bt_fav;
            public ImageView line;
            private Context context;

            public ViewHolder(Context context, View itemView) {
                super(itemView);
                cardTitle = (TextView) itemView.findViewById(R.id.dash_rv_card_tv_title);
                cardDesc = (TextView) itemView.findViewById(R.id.dash_rv_card_tv_desc);
                bt_details = (Button) itemView.findViewById(R.id.dash_rv_card_bt_detail);
                bt_fav = (Button) itemView.findViewById(R.id.dash_rv_card_bt_nav);
                line = (ImageView) itemView.findViewById(R.id.dash_rv_card_line);
                // Store the context
                this.context = context;
                // Attach a click listener to the entire row view
                itemView.setOnClickListener(this);
                bt_details.setOnClickListener(this);
                bt_fav.setOnClickListener(this);
                bt_fav.setText("FAVORITE");
            }

            // Handles the row being being clicked
            @Override
            public void onClick(View view) {
                int position = getAdapterPosition(); // gets item position
                if(view==bt_details) {
                        if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                        EventDetails card = meventCard.get(position);
                        EventDetailActivity.getCardData(card, position);
                        // We can access the data within the views
                        Intent intent = new Intent(context, EventDetailActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        context.startActivity(intent);
                    }
                }
               else {
                    EventDetails card2 = meventCard.get(position);
                    if(bt_fav.getText()=="FAVORITE"){
                       card2.setEvent_favorite(1);
                       meventCard.set(position,card2);
                       bt_fav.setText("UNFAVORITE");
                    }
                    else{
                        card2.setEvent_favorite(0);
                        meventCard.set(position,card2);
                        bt_fav.setText("FAVORITE");
                    }
                }
            }
        }

        public eventCardAdapter(Context context, ArrayList<EventDetails> eventCard) {
            meventCard = eventCard;
            mcontext = context;
        }

        private Context getContext() {
            return mcontext;
        }

        @Override
        public eventCardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater layoutInflater = LayoutInflater.from(context);

            View cardview = layoutInflater.inflate(R.layout.dash_rv_eventcard, parent, false);

            ViewHolder viewHolder = new ViewHolder(context, cardview);
            return (viewHolder);
        }

        @Override
        public void onBindViewHolder(eventCardAdapter.ViewHolder viewHolder, int position) {
            // Get the data model based on position
            EventDetails event_card = meventCard.get(position);
            int color, colorDark;
            color = getResources().getColor(R.color.colorBOADark);
            colorDark = getResources().getColor(R.color.colorAccent);
            //String selectCat = eventCardCategoryAdapter.getSelectedCat();
            //if(event_card.getCard_category()=="Best of Amitech") {
                // Set item views based on your views and data model
                TextView cardtitle = viewHolder.cardTitle;
                TextView carddesc = viewHolder.cardDesc;
                Button card_det = viewHolder.bt_details;
                Button card_fav = viewHolder.bt_fav;
                ImageView line = viewHolder.line;
                cardtitle.setText(event_card.getCard_title());
                carddesc.setText(event_card.getCard_desc());
                switch (selectedCat){
                    case "ALL EVENTS":
                        color = getResources().getColor(R.color.colorAll);
                        colorDark = getResources().getColor(R.color.colorAllDark);
                        break;
                    case "BEST OF AMITECH":
                        color = getResources().getColor(R.color.colorBOA);
                        colorDark = getResources().getColor(R.color.colorBOADark);
                        break;
                    case "FUN":
                        color = getResources().getColor(R.color.colorFun);
                        colorDark = getResources().getColor(R.color.colorFunDark);
                        break;
                    case "CULTURAL":
                        color = getResources().getColor(R.color.colorCultural);
                        colorDark = getResources().getColor(R.color.colorCulturalDark);
                        break;
                    case "TECHNICAL":
                        color = getResources().getColor(R.color.colorTechnical);
                        colorDark = getResources().getColor(R.color.colorTechnicalDark);
                        break;
                    case "LITERARY":
                        color = getResources().getColor(R.color.colorLiterary);
                        colorDark = getResources().getColor(R.color.colorLiteraryDark);
                        break;
                    case "SPONSORED":
                        color = getResources().getColor(R.color.colorSponsored);
                        colorDark = getResources().getColor(R.color.colorSponsoredDark);
                        break;
                    default:
                       color = getResources().getColor(R.color.colorBOA);
                       colorDark = getResources().getColor(R.color.colorBOADark);
                       break;
                }
                cardtitle.setBackgroundColor(colorDark);
                cardtitle.setTextColor(color);
                card_det.setTextColor(colorDark);
                card_fav.setTextColor(colorDark);
                line.setBackgroundColor(color);
            //}
            /*else {
                meventCard.remove(event_card);
                cardAdapter.notifyDataSetChanged();
            }*/

        }

        @Override
        public int getItemCount() {
            return meventCard.size();
        }
    }
    public static void getSelectedFromDetails(String s){selectedCat=s;}
    //event category adapter

    class eventCardCategoryAdapter extends RecyclerView.Adapter<eventCardCategoryAdapter.ViewHolder> {
        private String[] namelist;
        private Context mcontext;

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            public TextView categoryName;
            private Context context;


            public ViewHolder(Context context, View itemView) {
                super(itemView);
                categoryName = (TextView) itemView.findViewById(R.id.category_name);

                // Store the context
                this.context = context;
                // Attach a click listener to the entire row view
                itemView.setOnClickListener(this);
            }

            // Handles the row being being clicked
            @Override
            public void onClick(View view) {
                String name=categoryName.getText().toString();
                switch(name) {
                    case "ALL EVENTS":
                        eventCard = makeEventData();
                        break;
                    case "BEST OF AMITECH":
                        eventCard = makeBOAData();
                        break;
                    case "FUN":
                        eventCard = makeFunData();
                        break;
                    case "CULTURAL":
                        eventCard = makeCultData();
                        break;
                    case "SPONSORED":
                        eventCard = makeSponData();
                        break;
                    case "LITERARY":
                        eventCard = makeLitData();
                        break;
                    case "TECHNICAL":
                        eventCard = makeTechData();
                        break;
                    default: eventCard=makeBOAData();
                    break;
                }
              categoryAdapter.notifyDataSetChanged();
              selectedCat=name;

              cardAdapter = new eventCardAdapter(context, eventCard);
              cardAdapter.notifyDataSetChanged();
              dash_rv_eventCard.setAdapter(cardAdapter);

              //dashHeader = (TextView) findViewById(R.id.dash_tv_cat_title);
              if(selectedCat!="BEST OF AMITECH")
              dashHeader.setText(selectedCat + " EVENTS");
              else
                  dashHeader.setText(selectedCat);
            }
        }

        public eventCardCategoryAdapter(Context context, String[] name) {
            namelist = name;
            mcontext = context;
            //selectedCat = "BEST OF AMITECH";
        }

        private Context getContext() {
            return mcontext;
        }

        @Override
        public eventCardCategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater layoutInflater = LayoutInflater.from(context);

            View categoryview = layoutInflater.inflate(R.layout.fragment_rv_category, parent, false);

            ViewHolder viewHolder = new ViewHolder(context, categoryview);
            return (viewHolder);
        }

        @Override
        public void onBindViewHolder(eventCardCategoryAdapter.ViewHolder viewHolder, int position) {
            // Get the data model based on position
            String categoryN = namelist[position];
            int draw; String col;
            col="#424242";
            // Set item views based on your views and data model
            TextView catName = viewHolder.categoryName;
            catName.setText(categoryN);
            switch (categoryN){
                case "ALL EVENTS":
                    if(selectedCat==categoryN) {
                        draw = R.drawable.s_category_all;
                        col="#ffffff";
                    }
                    else
                        draw = R.drawable.us_category_all;
                    break;
                case "BEST OF AMITECH":
                    if(selectedCat==categoryN) {
                        draw = R.drawable.s_category_boa;
                        col="#ffffff";
                    }
                    else
                        draw = R.drawable.us_category_boa;
                    break;
                case "FUN":
                    if(selectedCat==categoryN) {
                        draw = R.drawable.s_category_fun;
                        col="#ffffff";
                    }
                    else
                        draw = R.drawable.us_category_fun;
                    break;
                case "LITERARY":
                    if(selectedCat==categoryN) {
                        draw = R.drawable.s_category_lit;
                        col = "#ffffff";
                    }
                    else
                        draw = R.drawable.us_category_lit;
                    break;
                case "SPONSORED":
                    if(selectedCat==categoryN) {
                        draw = R.drawable.s_category_spon;
                        col = "#ffffff";
                    }
                    else
                        draw = R.drawable.us_category_spon;
                    break;
                case "CULTURAL":
                    if(selectedCat==categoryN) {
                        draw = R.drawable.s_category_cult;
                        col = "#ffffff";
                    }
                    else
                        draw = R.drawable.us_category_cult;
                    break;
                case "TECHNICAL":
                    if(selectedCat==categoryN) {
                        draw = R.drawable.s_category_tech;
                        col = "#ffffff";
                    }
                    else
                        draw = R.drawable.us_category_tech;
                    break;
                default:
                    if(selectedCat==categoryN) {
                        draw = R.drawable.s_category_boa;
                        col="#ffffff";
                    }
                    else
                        draw = R.drawable.us_category_boa;
                    break;
            }
            catName.setBackgroundResource(draw);
            catName.setTextColor(Color.parseColor(col));
            if(selectedCat!="BEST OF AMITECH" && selectedCat!="ALL EVENTS")
                dashHeader.setText(selectedCat + " EVENTS");
            else
                dashHeader.setText(selectedCat);
        }

        @Override
        public int getItemCount() {return namelist.length;}

        //public static String getSelectedCat(){return selectedCat;}
    }
    /*class eventCategoryAdapter extends RecyclerView.Adapter<eventCategoryAdapter.CategoryViewHolder>{
        private String[] cat;
        private Context mcontext;

        public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            public TextView categoryName;
            private Context con;
            public CategoryViewHolder(Context context, View itemview){
                super(itemview);
                categoryName = (TextView) findViewById(R.id.category_name);
                this.con=context;
                itemview.setOnClickListener(this);
            }
            @Override
            public void onClick(View view){

            }
        }

        public eventCategoryAdapter(Context context, String[] category){
            this.mcontext = context;
            this.cat = category;

        }

        private Context getContext() {
            return mcontext;
        }

        @Override
        public eventCategoryAdapter.CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            //Context context = parent.getContext();
           // LayoutInflater layoutInflater = LayoutInflater.from(context);

           // View cardview = layoutInflater.inflate(R.layout.dash_rv_eventcard, parent, false);

            //eventCardAdapter.ViewHolder viewHolder = new eventCardAdapter.ViewHolder(context, cardview);
            //return (viewHolder);

            Context context = parent.getContext();
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View category_view = layoutInflater.inflate(R.layout.fragment_rv_category, parent, false);
            eventCategoryAdapter.CategoryViewHolder holder = new eventCategoryAdapter.CategoryViewHolder(context, category_view);
            return (holder);
        }

        @Override
        public void onBindViewHolder (eventCategoryAdapter.CategoryViewHolder holder, int position){
            String name = cat[position];
            //TextView categoryName = holder.categoryName;
            holder.categoryName.setText(name);
        }

        @Override
        public int getItemCount(){return (cat.length);}
    }*/
}
    /*private class ContentAdapter extends RecyclerView.Adapter<ViewHolder>{
        @Override
        public ContentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(ContentAdapter.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }

    private class ViewHolder {
    }:
}*/
