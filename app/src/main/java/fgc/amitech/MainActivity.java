package fgc.amitech;



import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {
    private LinearLayoutManager layoutManager;
    private RecyclerView.ViewHolder viewHolder;
    List<event> eventList;

    String change_text[] = {"is here", "have fun!!", "it is fun!!", "Let's explore", "let's do it", "Let's participate"};
    private TextSwitcher mSwitcher;
    private int mCounter = 0;
    private DrawerLayout mDrawerLayout;
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
    private RecyclerView dash_eventCard;
    private eventCardAdapter cardAdapter;
    private ArrayList<EventDetails> eventCard = new ArrayList<EventDetails>();

    //--finish--
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //WindowManager.LayoutParams.FLAG_FULLSCREEN);
      //  FragmentManager fragmentManager = getSupportFragmentManager();
      //  final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
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

        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(0).setChecked(true);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                      //  Fragment fragment = null;
                     //  menuItem.setChecked(true);

                            // close drawer when item is tapped
                        //    mDrawerLayout.closeDrawers();
                        switch (menuItem.getItemId()) {
                            case R.id.house:
                                startActivity(new Intent(MainActivity.this,MainActivity.class)); finish(); break;
                                //setContentView(R.layout.activity_dash);

                            case R.id.contact:
                                // i=new Intent(MainActivity.this,Contact_activity.class);
                                startActivity(new Intent(MainActivity.this,Contact_activity.class)); finish(); break;
                                //Fragment fragment = new ContactActivity();
                               // fragmentTransaction.add(R.id.mainArea, fragment);
                               // fragmentTransaction.commit();break;
                              //  Intent i=new Intent(MainActivity.this,ContactActivity.class);
                              //  startActivity(i); finish(); break;

                           case R.id.sponsor:// i=new Intent(MainActivity.this,SponsorActivity.class);
                               startActivity(new Intent(MainActivity.this,SponsorActivity.class)); finish(); break;

                            case R.id.events: //i=new Intent(MainActivity.this,EventActivity.class);
                                startActivity(new Intent(MainActivity.this,EventActivity.class)); finish(); break;
                            //    newGame();
                             //   return true;
                            //default:
                              //  menuItem.setChecked(true);
                              //  mDrawerLayout.closeDrawers();
                                //if (fragment != null) {
                                  //  FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                                //    ft.add(R.id.mainArea, fragment);

                                 //   setTitle("Contact Us");
                                 //   ft.commit();break;
                               // mDrawerLayout.closeDrawers();
                              //  }
                        }
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here*/
                      //  displaySelectedScreen(menuItem.getItemId());
                        return true;
                    }
                });


        //Creating the data set for the event card
        eventCard = EventDetails.makeEventData();
        LinearLayoutManager layoutManager_rv = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        dash_eventCard = (RecyclerView) findViewById(R.id.dash_rv_eventcard);
        dash_eventCard.setLayoutManager(layoutManager_rv);
        cardAdapter = new eventCardAdapter(this, eventCard);
        dash_eventCard.setAdapter(cardAdapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
       //actionbar.setTitle("Home");

        toolbar.setTitleTextColor(Color.WHITE);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears//simple_spinner_item
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_activated_1);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);
        /*RecyclerView rv=(RecyclerView)findViewById(R.id.mainRecycle);
        rv.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);*/
//ContentAdapter adapter=new ContentAdapter(rv.getContext(),eventList);

    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
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

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

   // String item=adapterView.getItemAtPosition(i).toString();
     switch(adapterView.getSelectedItemPosition()) {
         case 0: break;
         case 1: startActivity(new Intent(MainActivity.this, EventActivity.class));
             finish(); break;
         case 2:
             startActivity(new Intent(MainActivity.this, Contact_activity.class));
             finish();break;
     }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    //public ArrayList<EventDetails> getCardData() { return eventCard; }

    class eventCardAdapter extends RecyclerView.Adapter<eventCardAdapter.ViewHolder> {
        private ArrayList<EventDetails> meventCard;
        private Context mcontext;

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            public TextView cardTitle;
            public TextView cardDesc;
            public Button bt_details;
            private Context context;

            public ViewHolder(Context context, View itemView) {
                super(itemView);
                cardTitle = (TextView) itemView.findViewById(R.id.dash_rv_card_tv_title);
                cardDesc = (TextView) itemView.findViewById(R.id.dash_rv_card_tv_desc);
                bt_details = (Button) itemView.findViewById(R.id.dash_rv_card_bt_detail);
                // Store the context
                this.context = context;
                // Attach a click listener to the entire row view
                itemView.setOnClickListener(this);
                bt_details.setOnClickListener(this);
            }

            // Handles the row being being clicked
            @Override
            public void onClick(View view) {
                int position = getAdapterPosition(); // gets item position
                if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                    EventDetails card = meventCard.get(position);
                    EventDetailActivity.getCardData(card,position);
                    // We can access the data within the views
                    context.startActivity(new Intent(context, EventDetailActivity.class));
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
            //Get the data model based on position
            EventDetails event_card = meventCard.get(position);
            //Set item views based on your views and data model
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
