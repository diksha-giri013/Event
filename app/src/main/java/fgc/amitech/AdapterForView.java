package fgc.amitech;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by payal on 17-02-2018.
 */

class AdapterForView extends PagerAdapter{
    private Context mCtx;
    private LayoutInflater layoutInflater;
    public String[] heading={
            "Participate And Win Exciting Goodies",
            "Two Liner Highlight Text",
            "Two Liner Highlight Text"
    };
    public String[] number_text={
            "50+",
            "600+",
            "75+"
    };
    public String[] number_text2={
            "Fun Filled Events",
            "Participations",
            "Spectacular Prizes"
    };
    public String[] list_text={
            "Enjoy to your fullest while gaining creative intellect by being a part of them!",
            "Enjoy to your fullest while gaining creative intellect by being a part of them!",
            "Enjoy to your fullest while gaining creative intellect by being a part of them!"
    };
    public AdapterForView(Context mCtx) {
    this.mCtx=mCtx;
    }


    @Override
    public int getCount() {
        return list_text.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==(LinearLayout)object;//**change to appropriate layout
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater=(LayoutInflater)mCtx.getSystemService(mCtx.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.ob_vp_content,container,false);

        TextView text1=(TextView) view.findViewById(R.id.ob_vp_tv_header);
        text1.setText(heading[position]);
        TextView text2=(TextView) view.findViewById(R.id.ob_vp_tv_stat);
        text2.setText(number_text[position]);
        TextView text3=(TextView) view.findViewById(R.id.ob_vp_tv_subtitle);
        text3.setText(number_text2[position]);
        TextView text4=(TextView) view.findViewById(R.id.ob_vp_tv_desc);
        text4.setText(list_text[position]);

       // ImageView spaceshipImage = (ImageView)view.findViewById(R.id.image);
      //  Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(mCtx, R.anim.bounce);
      //  spaceshipImage.startAnimation(hyperspaceJumpAnimation);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }

}
