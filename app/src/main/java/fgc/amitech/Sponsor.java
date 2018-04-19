package fgc.amitech;

import android.graphics.Color;

import java.util.ArrayList;

/**
 * Created by payal on 20-03-2018.
 */

public class Sponsor {
    private String mhead;

    private String mpost;
    private String mname;
    private int mpic;
    private int mcrown;
    //  private int mwhtsapp;
    //  private int mcall;

    public Sponsor(String head,String post, String name, int pic,int crown) {
        mhead = head;
        mpost = post;
        mname = name;
        mpic = pic;
        mcrown = crown;
        //   mwhtsapp = whtsapp;
        //mcall = call;
    }
    public String getHead() {
        return mhead;
    }
    public String getPost() {
        return mpost;
    }

    public String getmName() {
        return mname;
    }

    public int getPic() {
        return mpic;
    }
    public int getCrown() {
        return mcrown;
    }

    // public int getWhtsapp() {
    // return mwhtsapp;
    // }

    // public int getCall() {
    //  return mcall;
    //   }

    public static ArrayList<Sponsor>createSponsorList(){
        Sponsor sponsor_card;
        String[] spoHead;

        String[] spoPost;
        String[] spoName;
        int[] picture;
        int[] crown;
        // int whatsapp;
        // int call;
        ArrayList<Sponsor> sponsors=new ArrayList<Sponsor>();
        spoHead = new String[]{
                "Title sponsor",
                "Power sponsor",
                "Event sponsor",
                "Associate sponsor",
                "Coding Partner",
                "Associate sponsor",
                "Associate sponsor",
                "Technology partner",
                "Associate sponsor",
                "Associate sponsor",
                "Associate sponsor",
                "Associate sponsor",
                "Associate sponsor",
                "Student Partner",
                "Associate sponsor",
                "Associate sponsor",
                "Associate sponsor",
                "Associate sponsor",
                "Associate sponsor",
                "Associate sponsor"

        };
        spoPost = new String[]{
                "Garniche",
                "Developing Success Institute",
                "Canvas Laugh Club",
                "ACE Academy",
                "Coding Blocks",
                "Gate Coach",
                "Career Launcher",
                "Feels Goods Creations",
                "Frapp",
                "Rhapsody",
                "OYO",
                "LensKart",
                "Smaash",
                "Integer Innovation",
                "Make my Trip",
                "Udemy",
                "Printvenue.com",
                "GoDaddy",
                "Zalonin",
                "Thappa Chinese Corner"
        };
        spoName = new String[]{
                "Chef at your Doorstep",
                "One thing that matters to you and us, is your result and success",
                "You need some CLC!",
                "Engineering Academy",
                "Code your way to success",
                "Best coaching institute for IES/GATE/PSU since 1997",
                "Helping the youth of the country achieve their career dreams",
                "Spreading happiness feels good",
                "Students only",
                "Nail Studio",
                "On your own rooms",
                "Spexy is the new sexy!",
                "Can't Stop Playing",
                "Learn.play.Innovate.",
                "Dil toh roaming hai",
                "",
                "",
                "It's Go time",
                "Be the way you want to be",
                ""

        };
        picture=new int[]{
                R.drawable.logotitle_new,
                R.drawable.logo_devloping_success,
                R.drawable.clc,
                R.drawable.logo_ace_academy,
                R.drawable.logo_coding_blocks,
                R.drawable.logo_gate_coach,
                R.drawable.logo_career_launcher,
                R.drawable.fgc,
                R.drawable.logo_frapp,
                R.drawable.logo_rhapsody_nail_saloon,
                R.drawable.logo_oyo,
                R.drawable.logo_lenskart,
                R.drawable.logo_smaash,
                R.drawable.logo_integer_innovation,
                R.drawable.logo_makemytrip,
                R.drawable.logo_udemy,
                R.drawable.logo_printvenue,
                R.drawable.logo_godaddy,
                R.drawable.zalonin,
                R.drawable.logo_thapa_chinese_food

        };
        crown=new int[]{



                Color.parseColor("#FBC02D"),
                Color.parseColor("#BDBDBD"),
                Color.parseColor("#FBC02D"),
                Color.parseColor("#795548"),
                Color.parseColor("#795548"),
                Color.parseColor("#795548"),
                Color.parseColor("#795548"),
                Color.parseColor("#795548"),
                Color.parseColor("#795548"),
                Color.parseColor("#795548"),
                Color.parseColor("#795548"),
                Color.parseColor("#795548"),
                Color.parseColor("#795548"),
                Color.parseColor("#795548"),
                Color.parseColor("#795548"),
                Color.parseColor("#795548"),
                Color.parseColor("#795548"),
                Color.parseColor("#795548"),
                Color.parseColor("#795548"),
                Color.parseColor("#795548"),
                Color.parseColor("#795548"),


        };

        for (int i = 0; i <spoHead.length; i++) {
            sponsor_card = new Sponsor(spoHead[i],spoPost[i], spoName[i],picture[i],crown[i]);
            sponsors.add(sponsor_card);

        }
        return sponsors;
    }}