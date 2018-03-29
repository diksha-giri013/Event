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
                "power sponsor",
                "associate sponsor",
                "food partner",
                "Social Media sponsor",
                "Event sponsor"
        };
        spoPost = new String[]{

                "Ford",
                "Vivo",
                "UrbanClap",
                "Coca Cola",
                "Feels Goods Creations",
                "Canvas Laugh Club"
        };
        spoName = new String[]{

                "Built to Last",
                "Camera & Music",
                "Your Service expert",
                "Taste the feeling",
                "I3DEA",
                "You need some CLC!"
        };
        picture=new int[]{
                R.drawable.logoford,
                R.drawable.snowy,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_navigate_before,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_call_24dp
        };
        crown=new int[]{


                Color.parseColor("#FBC02D"),
                Color.parseColor("#BDBDBD"),
                Color.parseColor("#795548"),
                Color.parseColor("#2E7D32"),
                Color.parseColor("#FBC02D"),
                Color.parseColor("#FBC02D")

        };

        for (int i = 0; i < 6; i++) {
            sponsor_card = new Sponsor(spoHead[i],spoPost[i], spoName[i],picture[i],crown[i]);
            sponsors.add(sponsor_card);

        }
        return sponsors;
    }}