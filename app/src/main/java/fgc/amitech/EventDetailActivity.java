package fgc.amitech;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class EventDetailActivity extends AppCompatActivity {
    private ArrayList<EventDetails> cardData;
    private static EventDetails card_data;
    private TextView detail_title;
    private static int card_pos;
    private Button btn_next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
        //cardData= MainActivity.getCardData();

        detail_title = (TextView) findViewById(R.id.detail_tv_evname);
        detail_title.setText(card_data.getCard_title());
        }
   public static void getCardData(EventDetails card, int pos){
        card_data=card;
        card_pos=pos;
   }
}
