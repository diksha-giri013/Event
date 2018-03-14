package fgc.amitech;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import static fgc.amitech.EventDetails.makeEventData;

public class EventDetailActivity extends AppCompatActivity{
    private ArrayList<EventDetails> cardData;
    private static EventDetails card_data;

    private TextView detail_title;
    private TextView detail_desc;
    private TextView detail_date;
    private TextView detail_member;
    private TextView detail_loc;
    private TextView detail_rule;
    private static int card_pos;

    private Button btn_next;
    private Button btn_prev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
        cardData = makeEventData();

        detail_title = (TextView) findViewById(R.id.detail_tv_evname);
        detail_desc = (TextView) findViewById(R.id.detail_tv_evdesc);
        detail_date = (TextView) findViewById(R.id.detail_tv_evdate);
        detail_member = (TextView) findViewById(R.id.detail_tv_teamsize);
        detail_loc = (TextView) findViewById(R.id.detail_tv_location);
        detail_rule = (TextView) findViewById(R.id.detail_tv_rule);
        populateDetails();

        btn_next = (Button) findViewById(R.id.detail_btn_next);
        if(card_pos==cardData.size()-1) btn_next.setVisibility(View.INVISIBLE);

        btn_prev = (Button) findViewById(R.id.detail_btn_prev);
        if(card_pos==0) btn_prev.setVisibility(View.INVISIBLE);
       }

    public void populateDetails(){
        detail_title.setText(card_data.getCard_title());
        detail_desc.setText(card_data.getCard_desc());
        detail_date.setText(card_data.getEvent_date());
        detail_member.setText(card_data.getEvent_members());
        detail_loc.setText(card_data.getEvent_location());
        detail_rule.setText(card_data.getEvent_rules());
    }

    public void navclick(View view){
            Intent map = new Intent(EventDetailActivity.this, MapsActivity.class);
            startActivity(map); }

   public void onbtnClick(View v) {

       if(v==btn_next)
           card_pos++;
       else
           card_pos--;

           card_data = cardData.get(card_pos);
           populateDetails();

           if(card_pos == cardData.size() - 1) btn_next.setVisibility(View.INVISIBLE);
           if(card_pos < cardData.size()-1) btn_next.setVisibility(View.VISIBLE);

           if(card_pos == 0) btn_prev.setVisibility(View.INVISIBLE);
           if(card_pos > 0) btn_prev.setVisibility(View.VISIBLE);
  }

   public static void getCardData(EventDetails card, int pos){ //gets the data of the card clicked in RV
        card_data=card;
        card_pos=pos;
   }
}
