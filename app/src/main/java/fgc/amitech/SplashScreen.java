package fgc.amitech;

import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {
    private static  int SPLASH_TIME_OUT=4000;
    private PrefManager prefManager;
AnimatedVectorDrawable avd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //ImageView myAnimation = findViewById(R.id.aniImage);
        //avd = (AnimatedVectorDrawable)myAnimation.getDrawable();
        //new Handler().postDelayed(new Runnable() {
            // myAnimation.post(new Runnable() {
            //@Override
           // public void run() {
                //Intent homeIntent=new Intent(SplashScreen.this,OnBoarding.class);
                //startActivity(homeIntent);
               // avd.start();
                //finish();
                ImageView v = findViewById(R.id.aniImage);
                Drawable d = v.getDrawable();
                if (d instanceof AnimatedVectorDrawable) {
                    AnimatedVectorDrawable avd = (AnimatedVectorDrawable) d;

                    avd.start();
                } else if (d instanceof AnimatedVectorDrawableCompat) {
                    AnimatedVectorDrawableCompat avd = (AnimatedVectorDrawableCompat) d;

                    avd.start();
                }
           // }
       // });
        //,SPLASH_TIME_OUT);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent2=new Intent(SplashScreen.this,MainActivity.class);
                Intent onboardIntent=new Intent(SplashScreen.this,OnBoarding.class);
                prefManager = new PrefManager(SplashScreen.this);
                if (!prefManager.isFirstTimeLaunch()) {
                    prefManager.setFirstTimeLaunch(false);
                    startActivity(homeIntent2);
                    finish();}
                else{
                    startActivity(onboardIntent);
                finish();}
            }
        },SPLASH_TIME_OUT);

    }
}
