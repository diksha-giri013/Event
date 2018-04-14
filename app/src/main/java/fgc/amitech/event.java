package fgc.amitech;

import java.util.ArrayList;

/**
 * Created by payal on 04-03-2018.
 */

public class event {
    private String mhead;
    private static ArrayList<EventDetails> list;
    public event(String head)
    {
        mhead = head;
    }
    public String getHead() {
        return mhead;
    }
    public static ArrayList<event> showEvent(){
        event event_card;
        String[] spoHead;

        list = EventDetails.makeEventData();
        ArrayList<event> events=new ArrayList<event>();
        spoHead = new String[]{
                "Argumentum",
                "Battle Of Bands",
                "Technovation",
                "Sherlock Quiz",
                "Stupid Cupid",
                "Tambola",
                "Beg Borrow Steal",
                "Kalakaari",
                "Fashion Fingers",
                "Serenade",
                "Natraj",
                "Guess Who?",
                "Star Night",
                "Technovation",
                "Counter Strike",
                "Mini Militia",
                "Swish 'N' Click",
                "Ad Mad",
                "Power To Her",
                "Rumble Jumble",
                "You Me Mad"
        };
        for (int i = 0; i < list.size(); i++) {
            event_card = new event(list.get(i).getCard_title());
            events.add(event_card);

        }
        return events;
}}
