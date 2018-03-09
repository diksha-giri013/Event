package fgc.amitech;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.service.notification.StatusBarNotification;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.rd.PageIndicatorView;

public class OnBoarding extends AppCompatActivity {
    ViewPager viewPager;
    private AdapterForView adapterForView;
    LinearLayout sliderDotsPanel;
   // private int dotsCount;
   // private ImageView[] dots;
private int mCurrentPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        viewPager=(ViewPager)findViewById(R.id.vp_intro);
        //sliderDotsPanel=findViewById(R.id.sliderDots);
        final PageIndicatorView pageIndicatorView = findViewById(R.id.pageIndicatorView);
        pageIndicatorView.setCount(3);

        adapterForView=new AdapterForView(this);
        viewPager.setPageTransformer(true,new DepthPageTransformer());

        viewPager.setAdapter(adapterForView);
        Button skip=(Button) findViewById(R.id.skip_button);
        final Button previous=(Button) findViewById(R.id.previous);
        final Button next=(Button) findViewById(R.id.next);

        /*skip.setOnClickListener(new View.OnClickListener() {
        @Override
         public void onClick(View view) {
        Intent i=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
        }
        });


       // dotsCount=adapterForView.getCount();
      //  dots=new ImageView[dotsCount];
        /*for(int i=0;i<dotsCount;i++)
        {
            dots[i]=new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_crop_square_black_24dp));
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8,0,8,0);
            sliderDotsPanel.addView(dots[i],params);
        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_asset_3));*/
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {



            }

            @Override
            public void onPageSelected(int position) {
              /*  for(int i=0;i<dotsCount;i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_crop_square_black_24dp));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_asset_3));*/
                pageIndicatorView.setSelection(position);
                mCurrentPage=position;
                if(position==0)
                {
                    //next.setEnabled(true);
                    //navigate.setEnabled(true);
                    previous.setEnabled(false);
                    previous.setVisibility(View.INVISIBLE);
                    next.setText("NEXT");

                }
                else if(position==2){
                    previous.setEnabled(true);
                    previous.setVisibility(View.VISIBLE);
                    next.setText("FINISH");
                }
                else
                {
                    //next.setEnabled(true);
                    //navigate.setEnabled(true);
                    previous.setEnabled(true);
                    previous.setVisibility(View.VISIBLE);
                    //navigate.setImageDrawable(getDrawable(R.drawable.ic_navigate_next));
                    next.setText("NEXT");

                }
                //viewPager.setBackgroundColor(919191);                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {


            }
        });
    }
    //int j=viewPager.getCurrentItem();
    public void obClick(View view) {
        switch (view.getId()) {
            //case R.id.imageButton:
            case R.id.next:

                    if(viewPager.getCurrentItem()==0)viewPager.setCurrentItem(1);
                else if(viewPager.getCurrentItem()==1)viewPager.setCurrentItem(2);
                    else{ Intent i=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(i); finish(); }break;

            case R.id.previous:
                 if(viewPager.getCurrentItem()==1)viewPager.setCurrentItem(0);
            else if(viewPager.getCurrentItem()==2) viewPager.setCurrentItem(1);
            break;
            case R.id.skip_button:Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i); finish(); break;

        }}
}
