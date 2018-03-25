package fgc.amitech;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static fgc.amitech.EventDetails.makeBOAData;
import static fgc.amitech.EventDetails.makeCultData;
import static fgc.amitech.EventDetails.makeEventData;
import static fgc.amitech.EventDetails.makeFunData;
import static fgc.amitech.EventDetails.makeLitData;
import static fgc.amitech.EventDetails.makeSponData;
import static fgc.amitech.EventDetails.makeTechData;

public class EventDetailActivity extends AppCompatActivity {
    private ArrayList<EventDetails> cardData;
    private static EventDetails card_data;

    private TextView detail_title;
    private TextView detail_desc;
    private TextView detail_date;
    private TextView detail_member;
    private TextView detail_loc;
    private TextView detail_rule;
    private static int card_pos;
    private int color;
    private Button btn_next;
    private Button btn_prev;
    private Button nav;
    private Button reg;
    private ImageView ic_team;
    private ImageView ic_loc;
    private ImageView detail_grad;
    private ImageView detail_img;
    private Intent homeIntent;
    private GestureDetectorCompat mDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeIntent = new Intent(EventDetailActivity.this,MainActivity.class);
        //color= "@color/colorFunDark";
        setContentView(R.layout.activity_event_detail);

        nav = (Button) findViewById(R.id.detail_btn_nav);
        reg = (Button) findViewById(R.id.detail_btn_register);
        ic_team = (ImageView) findViewById(R.id.ic_act_evdetail_iv_team);
        ic_loc = (ImageView) findViewById(R.id.ic_act_evdetail_iv_loc);
        detail_title = (TextView) findViewById(R.id.detail_tv_evname);
        detail_desc = (TextView) findViewById(R.id.detail_tv_evdesc);
        detail_date = (TextView) findViewById(R.id.detail_tv_evdate);
        detail_member = (TextView) findViewById(R.id.detail_tv_teamsize);
        detail_loc = (TextView) findViewById(R.id.detail_tv_location);
        detail_rule = (TextView) findViewById(R.id.detail_tv_rule);
        detail_grad = (ImageView) findViewById(R.id.detail_iv_gradient);
        detail_img = (ImageView) findViewById(R.id.detail_iv_evimg);
        populateDetails();

        switch (card_data.getCard_category()){
            case "ALL EVENTS":
                color = getResources().getColor(R.color.colorAllDark);
                detail_grad.setImageDrawable(getResources().getDrawable(R.drawable.grad_boa));
                cardData = makeEventData();
                break;
            case "BEST OF AMITECH":
                color = getResources().getColor(R.color.colorBOADark);
                detail_grad.setImageDrawable(getResources().getDrawable(R.drawable.grad_boa));
                cardData = makeBOAData();
                break;
            case "FUN":
                color = getResources().getColor(R.color.colorFunDark);
                detail_grad.setImageDrawable(getResources().getDrawable(R.drawable.grad_fun));
                cardData = makeFunData();
                break;
            case "CULTURAL":
                color = getResources().getColor(R.color.colorCulturalDark);
                detail_grad.setImageDrawable(getResources().getDrawable(R.drawable.grad_cult));
                cardData = makeCultData();
                break;
            case "LITERARY":
                color = getResources().getColor(R.color.colorLiteraryDark);
                detail_grad.setImageDrawable(getResources().getDrawable(R.drawable.grad_lit));
                cardData = makeLitData();
                break;
            case "TECHNICAL":
                color = getResources().getColor(R.color.colorTechnicalDark);
                detail_grad.setImageDrawable(getResources().getDrawable(R.drawable.grad_tech));
                cardData = makeTechData();
                break;
            case "SPONSORED":
                color = getResources().getColor(R.color.colorSponsoredDark);
                detail_grad.setImageDrawable(getResources().getDrawable(R.drawable.grad_spon));
                cardData = makeSponData();
                break;
            default:
                color = getResources().getColor(R.color.colorAllDark);
                cardData = makeEventData();
                break;
        }
        //cardData = makeEventData();
        //cardData=filterEvents(cardData);

        btn_next = (Button) findViewById(R.id.detail_btn_next);
        if(card_pos==cardData.size()-1) btn_next.setVisibility(View.INVISIBLE);
        btn_next.setTextColor(color);

        btn_prev = (Button) findViewById(R.id.detail_btn_prev);
        //if(card_pos==0) btn_prev.setVisibility(View.INVISIBLE);
        btn_prev.setTextColor(color);
        nav.setTextColor(color);
        reg.setTextColor(color);
        }

    public void populateDetails(){
        detail_title.setText(card_data.getCard_title());
        detail_desc.setText(card_data.getCard_desc());
        detail_date.setText(card_data.getEvent_date());
        detail_member.setText(card_data.getEvent_members());
        detail_loc.setText(card_data.getEvent_location());
        detail_rule.setText(card_data.getEvent_rules());
        detail_img.setImageResource(card_data.getEvent_img());
    }

    public void navclick(View view){
            Intent map = new Intent(EventDetailActivity.this, MapsActivity.class);
            startActivity(map); }

   public void onbtnClick(View v) {

       if(v==btn_next)
           card_pos++;
       else
           card_pos--;

            if(card_pos>=0){
           card_data = cardData.get(card_pos);
           populateDetails();}

           if(card_pos == cardData.size() - 1) btn_next.setVisibility(View.INVISIBLE);
           if(card_pos < cardData.size()-1) btn_next.setVisibility(View.VISIBLE);

           if(card_pos == -1) {
               MainActivity.getSelectedFromDetails(card_data.getCard_category());
               homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
               startActivity(homeIntent);
               finish();
           }
           if(card_pos > 0) btn_prev.setVisibility(View.VISIBLE);
  }

   public static void getCardData(EventDetails card, int pos){ //gets the data of the card clicked in RV
        card_data=card;
        card_pos=card_data.getCard_pos()-1;
   }

   /*public ArrayList<EventDetails> filterEvents(ArrayList<EventDetails> data){
       EventDetails temp; int pos=0;
       while(pos<data.size()) {
           temp = data.get(pos);
           if (temp.getCard_category() != card_data.getCard_category()) {
               data.remove(temp);
           } pos++;
       }
      return data;
   }*/
}
