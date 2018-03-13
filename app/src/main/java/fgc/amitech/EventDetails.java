package fgc.amitech;

import java.util.ArrayList;

/**
 * Created by Diksha on 10-03-2018.
 */

public class EventDetails {
    public String card_title; //title for card and details
    public String card_desc; //description for card
    public String category; //category of the event
    public int card_pos; //position of the card in the rv

    public EventDetails(String title, String desc){
        this.card_title=title;
        this.card_desc=desc;
    }

    public String getCard_title(){return this.card_title;}
    public String getCard_desc(){return  this.card_desc;}
    public int getCard_pos() {return this.card_pos;}

    public static ArrayList<EventDetails> makeEventData(){
        EventDetails event_card;
        String[] cardTitle;
        String[] cardDesc;
        ArrayList<EventDetails> EventCard = new ArrayList<EventDetails>();
        cardTitle = new String[]{
                "Argumentum",
                "Battle Of Bands",
                "Technovation",
                "Sherlock Quiz"
        };

        cardDesc = new String[]{
                "Present your ideas and arguments logically. Be a part of this brilliant event and win prizes worth up to 40000!",
                "Present your ideas and arguments logically. Be a part of this brilliant event and win prizes worth up to 40000!",
                "Present your ideas and arguments logically. Be a part of this brilliant event and win prizes worth up to 40000!",
                "Present your ideas and arguments logically. Be a part of this brilliant event and win prizes worth up to 40000!"
        };
    for (int i = 0; i < 4; i++) {
        event_card = new EventDetails(cardTitle[i], cardDesc[i]);
        EventCard.add(event_card);
    }
    return EventCard;
    }

}
