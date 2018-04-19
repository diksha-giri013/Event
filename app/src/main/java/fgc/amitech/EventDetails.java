package fgc.amitech;

import java.util.ArrayList;

/**
 * Created by Diksha on 10-03-2018.
 */

public class EventDetails {
    public String card_title; //title for card and details
    public String card_desc; //description for card
    public String event_date; //Date of event;
    public String card_category; //category of the event
    public String event_members; //team size
    public String event_location; //On campus location
    public String event_rules; //guidelines
    public int event_favorite;
    public int event_img;
    public int card_pos; //position of the card in the rv

    public EventDetails(String title, String desc, String date, String cat, String teamsize, String loc, String rule, int pos, int draw){
        this.card_title=title;
        this.card_desc=desc;
        this.event_date = date;
        this.card_category=cat;
        this.event_members=teamsize;
        this.event_location=loc;
        this.event_rules=rule;
        this.card_pos=pos;
        this.event_img=draw;
    }

    public String getCard_title(){return this.card_title;}
    public String getCard_desc(){return  this.card_desc;}
    public String getEvent_date(){return  this.event_date;}
    public String getCard_category(){return  this.card_category;}
    public String getEvent_members(){return  this.event_members;}
    public String getEvent_location(){return  this.event_location;}
    public String getEvent_rules(){return  this.event_rules;}
    public int getEvent_img(){return  this.event_img;}
    public int getEvent_favorite() {return this.event_favorite;}
    public int getCard_pos() {return this.card_pos;}
    public void setEvent_favorite(int value){this.event_favorite=value;}

    public static ArrayList<EventDetails> makeEventData(){ //function for making the data set of events
        EventDetails event_card; //class object to store details
        ArrayList<EventDetails> EventCard = new ArrayList<EventDetails>(); //class object array list to store entire data set

        /*String[] title;
        String[] desc;
        String[] cat;
        String[] teamsize;
        String[] loc;
        String[] rule;
        String[] date;
        int[] pos;
        int[] image;

        title = new String[]{
                //BEST OF AMITECH
                "Argumentum",
                "Battle Of Bands",
                "Technovation",
                "Sherlock Quiz",
                //FUN Events
                "Stupid Cupid",
                "Tambola",
                "Beg Borrow Steal",
                //CULTURAL Events
                "Kalakaari",
                "Fashion Fingers",
                "Serenade",
                "Natraj"
        };

        desc = new String[]{
                "Welcome to the world of logical reasoning and brilliant articulation. Leave your mark as the best debtor and critical thinker.",
                "Present your ideas and arguments logically. Be a part of this brilliant event and win prizes worth up to 40000!",
                "Present your ideas and arguments logically. Be a part of this brilliant event and win prizes worth up to 40000!",
                "Present your ideas and arguments logically. Be a part of this brilliant event and win prizes worth up to 40000!",

                "This event does not feature bows and arrows sadly but you can still have fun! Participate and find stupidity!",
                "This event does not feature bows and arrows sadly but you can still have fun! Participate and find stupidity!",
                "This event does not feature bows and arrows sadly but you can still have fun! Participate and find stupidity!",

                "Showcase your talent and take your passion to the next level. Win prizes worth 50000!",
                "Showcase your talent and take your passion to the next level. Win prizes worth 50000!",
                "Showcase your talent and take your passion to the next level. Win prizes worth 50000!",
                "Showcase your talent and take your passion to the next level. Win prizes worth 50000!"
        };

        cat = new String[]{
                "BEST OF AMITECH",
                "BEST OF AMITECH",
                "BEST OF AMITECH",
                "BEST OF AMITECH",
                "FUN",
                "FUN",
                "FUN",
                "CULTURAL",
                "CULTURAL",
                "CULTURAL",
                "CULTURAL"
        };

        teamsize = new String[]{
                "2-4 Members",
                "3-8 Members",
                "2-5 Members",
                "Individual Participation",

                "Individual Participation",
                "2 Members",
                "Individual Participation",

                "6-10 Members",
                "3-8 Members",
                "7-9 Members",
                "2-5 Members"
        };

        rule = new String[]{"Rules are very important for any event read them. \nEach member can present one argument.\nCross questioning is not allowed, chill life.\nBring your own pen and paper.",
                "Rules are very important for any event read them. \nEach member can present one argument.",
                "Rules are very important for any event read them. \nEach member can present one argument.Rules are very important for any event read them. \nEach member can present one argument.",
                "Rules are very important for any event read them. \nEach member can present one argument.",

                "Rules are very important for any event read them. \nEach member can present one argument.",
                "Rules are very important for any event read them. \nEach member can present one argument.",
                "Rules are very important for any event read them. \nEach member can present one argument.",

                "Rules are very important for any event read them. \nEach member can present one argument.",
                "Rules are very important for any event read them. \nEach member can present one argument.",
                "Rules are very important for any event read them. \nEach member can present one argument.",
                "Rules are very important for any event read them. \nEach member can present one argument."};

        date = new String[]{
                "25 April 2018",
                "26 April 2018",
                "25 April 2018",
                "25 April 2018",

                "26 April 2018",
                "25 April 2018",
                "25 April 2018",

                "25 April 2018",
                "26 April 2018",
                "25 April 2018",
                "25 April 2018"
        };

        loc = new String[]{
                "Hall-2B",
                "Main Stage",
                "Auditorium",
                "Booth 3",

                "Ground",
                "Booth 5",
                "Booth 8",

                "Hall-2B",
                "Main Stage",
                "Auditorium",
                "Booth 3"
        };

        pos = new int[]{
                1,
                2,
                3,
                4,
                1,
                2,
                3,
                1,
                2,
                3,
                4
        };

        image = new int[]{
                R.drawable.event_img1,
                R.drawable.event_img2,
                R.drawable.event_img3,
                R.drawable.event_img4,
                R.drawable.event_img5,
                R.drawable.event_img6,
                R.drawable.event_img1,
                R.drawable.event_img2,
                R.drawable.event_img3,
                R.drawable.event_img4,
                R.drawable.event_img5
        };*/

        EventCard.addAll(makeTechData());
        EventCard.addAll(makeFunData());
        EventCard.addAll(makeCultData());
        //EventCard.addAll(makeSponData());
        EventCard.addAll(makeLitData());
        for(int i=0; i<EventCard.size(); i++){
            event_card=EventCard.get(i);
            event_card.card_category="ALL EVENTS";
            event_card.card_pos = i+1;
            EventCard.set(i,event_card);
        }

    /*for (int i = 0; i < pos.length; i++) {
        event_card = new EventDetails(title[i], desc[i], date[i], cat[i], teamsize[i], loc[i], rule[i], pos[i], image[i]);
        EventCard.add(event_card);
    }*/
    return EventCard;
    }

    public static ArrayList<EventDetails> makeBOAData(){ //function for making the data set of events
        EventDetails event_card; //class object to store details
        ArrayList<EventDetails> EventCard = new ArrayList<EventDetails>(); //class object array list to store entire data set

        String[] title;
        String[] desc;
        String[] cat;
        String[] teamsize;
        String[] loc;
        String[] rule;
        String[] date;
        int[] pos;
        int[] image;

        title = new String[]{
                //BEST OF AMITECH
                "Cook Without Fire",
                "Haste Raho",
                "Technovation",
                "Pixel Jones",
                "JAM Session",
                "Natraj"
                };

        desc = new String[]{
                "Food is life, cooking is fun. Young learners tried their hand in doing just that WITHOUT fire! An event brought to you by Garniche.",
                "Fodder for your funny bone from some of the best comedians and artists. Special appearance from Canvas Laugh Club peeps for you!",
                "I3DEA. Witness the rise of disruptive dreams in this startup event",
                "VIdualize the unavowed. An event to showcase your digital art expertise!",
                "Let Your Hair Down and loose yourself in the elated atmosphere !",
                "A solo dance competition to leave you awestruck"
        };

        cat = new String[]{
                "BEST OF AMITECH",
                "BEST OF AMITECH",
                "BEST OF AMITECH",
                "BEST OF AMITECH",
                "BEST OF AMITECH",
                "BEST OF AMITECH"
         };

        teamsize = new String[]{
                "Individual Participation",
                "Individual Participation",
                "2-5 Members",
                "1-3 Members",
                "Free for all event",
                "Individual Participation"
        };

        rule = new String[]{"Rules are very important for any event read them. \nEach member can present one argument.\nCross questioning is not allowed, chill life.\nBring your own pen and paper.",
                "Rules are very important for any event read them. \nEach member can present one argument.",
                "Rules are very important for any event read them. \nEach member can present one argument.",
                "Rules are very important for any event read them. \nEach member can present one argument.Rules are very important for any event read them. \nEach member can present one argument.",
                "Rules are very important for any event read them. \nEach member can present one argument.Rules are very important for any event read them. \nEach member can present one argument.",
                "Rules are very important for any event read them. \nEach member can present one argument.Rules are very important for any event read them. \nEach member can present one argument.",
                "Rules are very important for any event read them. \nEach member can present one argument."
        };

        date = new String[]{
                "21 April 2018",
                "21 April 2018",
                "22 April 2018",
                "21 April 2018",
                "21-22 April 2018",
                "22 April 2018"
        };

        loc = new String[]{
                "Classroom 1",
                "Moot Court",
                "Moot Court",
                "Classroom 1",
                "Moot Court",
                "Moot Court"
        };

        pos = new int[]{
                1,
                2,
                3,
                4,
                5,
                6
        };
        image = new int[]{
                R.drawable.pic_8,
                R.drawable.pic_2,
                R.drawable.pic_15,
                R.drawable.pic_5,
                R.drawable.event_img1,
                R.drawable.pic_14
        };

        for (int i = 0; i < pos.length; i++) {
            event_card = new EventDetails(title[i], desc[i], date[i], cat[i], teamsize[i], loc[i], rule[i], pos[i], image[i]);
            EventCard.add(event_card);
        }
        return EventCard;
    }

    public static ArrayList<EventDetails> makeFunData(){ //function for making the data set of events
        EventDetails event_card; //class object to store details
        ArrayList<EventDetails> EventCard = new ArrayList<EventDetails>(); //class object array list to store entire data set

        String[] title;
        String[] desc;
        String[] cat;
        String[] teamsize;
        String[] loc;
        String[] rule;
        String[] date;
        int[] pos;
        int[] image;

        title = new String[]{
                "Cook Without Fire",
                "JAM Session",
                "Metal Strength",
                "Mate In Two",
                "Bull's Eye"
        };

        desc = new String[]{
                "Food is life, cooking is fun. Young learners tried their hand in doing just that WITHOUT fire! An event brought to you by Garniche.",
                "Let Your Hair Down and loose yourself in the elated atmosphere ! ",
                "Put your strength to test in this push up event",
                "Defeat your opponent with the given chess setup in two moves.",
                "How good are you with your aim? Find out in this dart game. "
        };

        cat = new String[]{
                "FUN",
                "FUN",
                "FUN",
                "FUN",
                "FUN"
        };

        teamsize = new String[]{
                "Individual Participation",
                "Free For All Event",
                "Individual Participation",
                "Individual Participation",
                "Individual Participation"
        };

        rule = new String[]{
                "Rules are very important for any event read them. \n The rules for this event are coming soon.",

                "Rules are very important for any event read them. \n The rules for this event are coming soon.",
                "Rules are very important for any event read them. \n The rules for this event are coming soon.",
                "Rules are very important for any event read them. \n The rules for this event are coming soon.",
                "Rules are very important for any event read them. \n The rules for this event are coming soon."
        };

        date = new String[]{
                "21 April 2018",
                "21-22 April 2018",
                "21-22 April 2018",
                "21-22 April 2018",
                "21-22 April 2018"
        };

        loc = new String[]{
                "Classroom 1",
                "Moot Court",
                "Lobby",
                "Lobby",
                "Lobby"
        };

        pos = new int[]{
                1,
                2,
                3,
                4,
                5

        };
        image = new int[]{
                R.drawable.pic_8,
                R.drawable.event_img1,
                R.drawable.pic_13,
                R.drawable.pic_20,
                R.drawable.event_img4

        };

        for (int i = 0; i < pos.length; i++) {
            event_card = new EventDetails(title[i], desc[i], date[i], cat[i], teamsize[i], loc[i], rule[i], pos[i], image[i]);
            EventCard.add(event_card);
        }
        return EventCard;
    }

    public static ArrayList<EventDetails> makeCultData(){ //function for making the data set of events
        EventDetails event_card; //class object to store details
        ArrayList<EventDetails> EventCard = new ArrayList<EventDetails>(); //class object array list to store entire data set

        String[] title;
        String[] desc;
        String[] cat;
        String[] teamsize;
        String[] loc;
        String[] rule;
        String[] date;
        int[] pos;
        int[] image;

        title = new String[]{

                "Alaap",
                "Haste Raho",
                "Serenade",
                "Bhaavnayein",
                "Natraj",
                "Duet Dance"
        };

        desc = new String[]{
                "Witness the mastery of musical notes in this Solo Indian singing event by Decibel. ",
                "Fodder for your funny bone from some of the best comedians and artists. Special appearance from Canvas Laugh Club peeps for you!",
                "Witness the mastery of musical notes in this Solo Western singing event by Decibel.",

                "Talented individuals showcase their mono act presentations",
                "A solo dance event to leave you awestruck",
                "When Dance meets Chemistry"
        };

        cat = new String[]{
                "CULTURAL",
                "CULTURAL",
                "CULTURAL",

                "CULTURAL",
                "CULTURAL",
                "CULTURAL"
        };

        teamsize = new String[]{
                "1+3 members",
                "Individual Participation",
                "1+3 members",
                "Individual Participation",
                "Individual Participation",
                "2 members"
        };

        rule = new String[]{
                "Rules are very important for any event read them. \n The rules for this event are coming soon.",

                "Rules are very important for any event read them. \n The rules for this event are coming soon.",
                "Rules are very important for any event read them. \n The rules for this event are coming soon.",
                "Rules are very important for any event read them. \n The rules for this event are coming soon.",
                "Rules are very important for any event read them. \n The rules for this event are coming soon.",
                "Rules are very important for any event read them. \n The rules for this event are coming soon.",
        };

        date = new String[]{
                "21 April 2018",
                "21 April 2018",
                "21 April 2018",
                "21 April 2018",

                "22 April 2018",
                "22 April 2018",
        };

        loc = new String[]{
                "Moot Court",
                "Moot Court",
                "Moot Court",

                "Classroom 1",
                "Moot Court",
                "Moot Court"
        };

        pos = new int[]{

                1,
                2,
                3,
                4,
                5,
                6

        };
        image = new int[]{
                R.drawable.pic_1,
                R.drawable.pic_2,
                R.drawable.pic_3,
                R.drawable.pic_10,
                R.drawable.pic_14,
                R.drawable.pic_16
        };

        for (int i = 0; i < pos.length; i++) {
            event_card = new EventDetails(title[i], desc[i], date[i], cat[i], teamsize[i], loc[i], rule[i], pos[i], image[i]);
            EventCard.add(event_card);
        }
        return EventCard;
    }

    public static ArrayList<EventDetails> makeSponData(){ //function for making the data set of events
        EventDetails event_card; //class object to store details
        ArrayList<EventDetails> EventCard = new ArrayList<EventDetails>(); //class object array list to store entire data set

        String[] title;
        String[] desc;
        String[] cat;
        String[] teamsize;
        String[] loc;
        String[] rule;
        String[] date;
        int[] pos;
        int[] image;

        title = new String[]{

                "Cook Without Fire",
                "Haste raho"
               };

        desc = new String[]{
                "Food is life, cooking is fun. Young learners tried their hand in doing just that WITHOUT fire! An event brought to you by Garniche.",
                "Fodder for your funny bone from some of the best comedians and artists. Special appearance from Canvas Laugh Club peeps for you!"
        };

        cat = new String[]{
                "SPONSORED",
                "SPONSORED"
        };

        teamsize = new String[]{
                "Individual Participation",
                "Individual Participation"
        };

        rule = new String[]{
                "Rules are very important for any event read them. \n The rules for this event are coming soon.",
                "Rules are very important for any event read them. \n The rules for this event are coming soon."
        };

        date = new String[]{
                "21 April 2018",
                "21 April 2018"
        };

        loc = new String[]{
                "Classroom 1",
                "Moot Court"
        };

        pos = new int[]{

                1,
                2
        };

        image = new int[]{
                R.drawable.pic_8,
                R.drawable.pic_2
        };

        for (int i = 0; i < pos.length; i++) {
            event_card = new EventDetails(title[i], desc[i], date[i], cat[i], teamsize[i], loc[i], rule[i], pos[i], image[i]);
            EventCard.add(event_card);
        }
        return EventCard;
    }

    public static ArrayList<EventDetails> makeTechData(){ //function for making the data set of events
        EventDetails event_card; //class object to store details
        ArrayList<EventDetails> EventCard = new ArrayList<EventDetails>(); //class object array list to store entire data set

        String[] title;
        String[] desc;
        String[] cat;
        String[] teamsize;
        String[] loc;
        String[] rule;
        String[] date;
        int[] pos;
        int[] image;

        title = new String[]{

                "Pixel Jones",
                "LAN Gaming",
                "Logo Mania",
                "Technovation",
                "Codesense"
        };

        desc = new String[]{
                "Visualise the unavowed. An event to showcase your digital art expertise.",
                "Showcase your talent and take your passion to the next level. Win prizes worth 5000!",
                "A quiz by SAE.",
                "I3DEA. Witness the rise of disruptive dreams in this unique pitching event! ",
                "Showcase your talent and take your passion to the next level. Win prizes worth 5000!"
        };

        cat = new String[]{
                "TECHNICAL",
                "TECHNICAL",
                "TECHNICAL",
                "TECHNICAL",
                "TECHNICAL"
        };

        teamsize = new String[]{
                "1-3 Members",
                "Individual Participation",
                "Individual Participation",
                "2-5 Members",
                ""
        };

        rule = new String[]{
                "Rules are very important for any event read them. \n The rules for this event are coming soon.",
                "Rules are very important for any event read them. \n The rules for this event are coming soon.",
                "Rules are very important for any event read them. \n The rules for this event are coming soon.",
                "Rules are very important for any event read them. \n The rules for this event are coming soon.",
                "Rules are very important for any event read them. \n The rules for this event are coming soon.",
        };

        date = new String[]{
                "21 April 2018",
                "21-22 April 2018",
                "21 April 2018",
                "22 April 2018",
                "22 April 2018"
        };

        loc = new String[]{
                "Classroom 1",
                "Classroom 3",
                "Classroom 2",
                "Moot Court",
                "Classroom 1"
        };

        pos = new int[]{

                1,
                2,
                3,
                4,
                5
        };

        image = new int[]{
                R.drawable.pic_5,
                R.drawable.pic_19,
                R.drawable.pic_6,
                R.drawable.pic_15,
                R.drawable.pic_18
        };

        for (int i = 0; i < pos.length; i++) {
            event_card = new EventDetails(title[i], desc[i], date[i], cat[i], teamsize[i], loc[i], rule[i], pos[i], image[i]);
            EventCard.add(event_card);
        }
        return EventCard;
    }

    public static ArrayList<EventDetails> makeLitData(){ //function for making the data set of events
        EventDetails event_card; //class object to store details
        ArrayList<EventDetails> EventCard = new ArrayList<EventDetails>(); //class object array list to store entire data set

        String[] title;
        String[] desc;
        String[] cat;
        String[] teamsize;
        String[] loc;
        String[] rule;
        String[] date;
        int[] pos;
        int[] image;

        title = new String[]{

                "Argumentum",
                "The Golden Snitch"
        };

        desc = new String[]{
                "Showcase your talent and take your passion to the next level. Win prizes worth 50000!",
                "Showcase your talent and take your passion to the next level. Win prizes worth 50000!"
        };

        cat = new String[]{
                "LITERARY",
                "LITERARY"
        };

        teamsize = new String[]{
                "2 Members",
                "Individual Participation"
        };

        rule = new String[]{
                "Rules are very important for any event read them. \n The rules for this event are coming soon.",
                "Rules are very important for any event read them. \n The rules for this event are coming soon."
        };

        date = new String[]{
                "21 April 2018",
                "21 April 2018",
        };

        loc = new String[]{
                "Classroom 2",
                "Classroom 2"
        };

        pos = new int[]{

                1,
                2
        };

        image = new int[]{
                R.drawable.pic_9,
                R.drawable.pic_11
        };

        for (int i = 0; i < pos.length; i++) {
            event_card = new EventDetails(title[i], desc[i], date[i], cat[i], teamsize[i], loc[i], rule[i], pos[i], image[i]);
            EventCard.add(event_card);
        }
        return EventCard;
    }
}
