package fgc.amitech;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DeveloperActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;

    private RecyclerView mRecyclerView;

    private ArrayList<Develop> develops = new ArrayList<Develop>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        develops = Develop.createDeveloperList();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        DeveloperAdapter mAdapter = new DeveloperAdapter(this,develops);
        mRecyclerView.setAdapter(mAdapter);
        NavigationView navigationView = findViewById(R.id.nav_view);
       navigationView.getMenu().getItem(5).setChecked(true);

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        mDrawerLayout.closeDrawers();
                        switch (menuItem.getItemId()) {
                            case R.id.house:
                                startActivity(new Intent(DeveloperActivity.this,MainActivity.class)); finish(); break;
                            //setContentView(R.layout.activity_dash);

                            case R.id.contact:startActivity(new Intent(DeveloperActivity.this,Contact_activity.class)); finish(); break;
                            // i=new Intent(MainActivity.this,Contact_activity.class);
                            case R.id.sponsor:// i=new Intent(MainActivity.this,SponsorActivity.class);
                                startActivity(new Intent(DeveloperActivity.this,SponsorActivity.class)); finish(); break;
                            case R.id.eventshe: startActivity(new Intent(DeveloperActivity.this,EventSchedule.class)); finish();break;
                            case R.id.events: //i=new Intent(MainActivity.this,EventActivity.class);
                                startActivity(new Intent(DeveloperActivity.this,EventActivity.class)); finish(); break;
                            case R.id.developer: break;


                        }
                        menuItem.setChecked(true);
                        return true;
                    }
                });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);

        actionbar.setTitle("Developers");
        toolbar.setTitleTextColor(Color.WHITE);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);


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
    public class DeveloperAdapter extends RecyclerView.Adapter<DeveloperAdapter.ViewHolder> {
        private ArrayList<Develop> mSponsors;
        private Context mContext;


        public class ViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView mTextView0;
            public TextView mTextView1;
            public ImageView mImageView;
            private Context context;
            public ViewHolder(Context context,View v) {
                super(v);
               mTextView0 = v.findViewById(R.id.textView0);
                mTextView1 = v.findViewById(R.id.textView1);
                mImageView = v.findViewById(R.id.imageView);
                this.context = context;

            }
        }
        public DeveloperAdapter(Context context,ArrayList<Develop>develops){//*****
            mSponsors=develops;
            mContext=context;
        }

        private Context getContext(){
            return mContext;
        }
        @Override
        public DeveloperAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context=parent.getContext();
            LayoutInflater inflater= LayoutInflater.from(context);
            View sponsorView=inflater.inflate(R.layout.developer_rv_card, parent, false);
            DeveloperAdapter.ViewHolder vh = new DeveloperAdapter.ViewHolder(context,sponsorView);

            return vh;
        }

        @Override
        public void onBindViewHolder(DeveloperAdapter.ViewHolder holder, int position) {
            Develop sponsor=mSponsors.get(position);
            TextView textView0=holder.mTextView1;
            textView0.setText(sponsor.getHead());
            TextView textView=holder.mTextView0;
            textView.setText(sponsor.getPost());

          // for(int i=0; i<sponsor.getPost().length();i++)
         //  {
          //  {
            //while (sponsor.getPost().equals('\n'))textView.setText(sponsor.getPost());
           /* int i = 0;
            while (sponsor.getPost().charAt(i)!='\n'){

            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,90);
                //textView.setTextAppearance(DeveloperActivity.this, R.style.CustomText);
               textView.setText(String.valueOf(sponsor.getPost().charAt(i)));
              //  textView.setText(sponsor.getPost());
                i++;
            }//}*/

            ImageView imageView1=holder.mImageView;
            imageView1.setClipToOutline(true);

            //imageView1.setPadding(20,20,20,20);
            //imageView1.setClipBounds(2,2,2,2);
            imageView1.setImageResource(sponsor.getPic());

            // imageView2.setTint(sponsor.getCrown());
            //  imageView2.setColorFilter(getResources().getC);
            //  DrawableCompat.setTint(imageView2.getDrawable(),sponsor.getCrown());
            // ImageView v = findViewById(R.id.imageView6);


        }

        @Override
        public int getItemCount() {
            return mSponsors.size();
        }
}}
