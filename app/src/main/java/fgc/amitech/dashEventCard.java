package fgc.amitech;

/**
 * Created by Diksha on 10-03-2018.
 */

public class dashEventCard {
    public String card_title;
    public String card_desc;

    public dashEventCard(String title, String desc){
        this.card_title=title;
        this.card_desc=desc;
    }

    public String getCard_title(){return this.card_title;}
    public String getCard_desc(){return  this.card_desc;}
}
