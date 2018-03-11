package fgc.amitech;

import android.content.Context;
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
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private LinearLayoutManager layoutManager;
    private RecyclerView.ViewHolder viewHolder;
    List<event> eventList;

    String change_text[]={"is here","have fun!!","it is fun!!","Let's explore","let's do it","Let's participate"};
    private TextSwitcher mSwitcher;
    private int mCounter = 0;
    private static  int SPLASH_TIME_OUT=3000;
    private Handler handler = new Handler();

    // Define the code block to be executed
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            // Insert custom code here
            Random rand = new Random();
            int  mCounter = rand.nextInt(6);
            mSwitcher.setText(change_text[mCounter]);
            // Repeat every 2 seconds
            handler.postDelayed(runnable, SPLASH_TIME_OUT);
        }
    };

// Start the Runnable immediately

    //Start Event card variables
    public RecyclerView dash_eventCard;
    public eventCardAdapter cardAdapter;
    public dashEventCard event_card;
    public ArrayList<dashEventCard> eventCard = new ArrayList<dashEventCard>();
    public String[] card_title;
    public String[] card_desc;
    //--finish--
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


        //Creating the data set for the event card
        card_title= new String[]{
                "Argumentum",
                "Battle Of Bands",
                "Technovation",
                "Sherlock Quiz"
        };

        card_desc=new String[]{
                "Present your ideas and arguments logically. Be a part of this brilliant event and win prizes worth up to 40000!",
                "Present your ideas and arguments logically. Be a part of this brilliant event and win prizes worth up to 40000!",
                "Present your ideas and arguments logically. Be a part of this brilliant event and win prizes worth up to 40000!",
                "Present your ideas and arguments logically. Be a part of this brilliant event and win prizes worth up to 40000!"
        };

        for(int i=0;i<4;i++){
            event_card=new dashEventCard(card_title[i],card_desc[i]);
            eventCard.add(event_card);
        }
        LinearLayoutManager layoutManager_rv = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        dash_eventCard=(RecyclerView) findViewById(R.id.dash_rv_eventcard);
        dash_eventCard.setLayoutManager(layoutManager_rv);
        cardAdapter = new eventCardAdapter(this, eventCard);
        dash_eventCard.setAdapter(cardAdapter);

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
    };}

    class eventCardAdapter extends RecyclerView.Adapter<eventCardAdapter.ViewHolder> {
        private ArrayList<dashEventCard> meventCard;
        private Context mcontext;
        public class ViewHolder extends RecyclerView.ViewHolder {

            public TextView cardTitle;
            public TextView cardDesc;

            public ViewHolder(View itemView) {
                super(itemView);

                cardTitle = (TextView) itemView.findViewById(R.id.dash_rv_card_tv_title);
                cardDesc = (TextView) itemView.findViewById(R.id.dash_rv_card_tv_desc);
            }
        }
        public eventCardAdapter(Context context, ArrayList<dashEventCard> eventCard){
            meventCard=eventCard;
            mcontext=context;
        }
        private Context getContext() {
            return mcontext;
        }
        @Override
        public eventCardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater layoutInflater = LayoutInflater.from(context);

            View cardview = layoutInflater.inflate(R.layout.dash_rv_eventcard, parent, false);

            ViewHolder viewHolder = new ViewHolder(cardview);
            return(viewHolder);
        }

        @Override
        public void onBindViewHolder(eventCardAdapter.ViewHolder viewHolder, int position){
            // Get the data model based on position
            dashEventCard event_card=meventCard.get(position);
            // Set item views based on your views and data model
            TextView cardtitle = viewHolder.cardTitle;
            TextView carddesc = viewHolder.cardDesc;
            cardtitle.setText(event_card.getCard_title());
            carddesc.setText(event_card.getCard_desc());

        }

        @Override
        public int getItemCount() {
            return meventCard.size();
        }
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
