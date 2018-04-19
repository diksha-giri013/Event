package fgc.amitech;

import java.util.ArrayList;

/**
 * Created by payal on 20-03-2018.
 */

public class Develop {
    private String mhead;

    private String mpost;

    private int mpic;

    //  private int mwhtsapp;
    //  private int mcall;

    public Develop( String head, String post,int pic) {
       mhead = head;
        mpost = post;
        mpic = pic;
        //   mwhtsapp = whtsapp;
        //mcall = call;
    }
    public String getHead() {
       return mhead;
    }
    public String getPost() {
        return mpost;
    }
    public int getPic() {
        return mpic;
    }

    // public int getWhtsapp() {
    // return mwhtsapp;
    // }

    // public int getCall() {
    //  return mcall;
    //   }

    public static ArrayList<Develop>createDeveloperList(){
        Develop sponsor_card;
        String[] spoHead;

        String[] spoPost;
        int[] picture;
        // int whatsapp;
        // int call;
        ArrayList<Develop> develops=new ArrayList<Develop>();
       spoHead = new String[]{
                "Developer",
                "Developer",
                "Manager",
                "Associate Developer",
                "Associate Developer",
               "Associate Developer",
                "Head Coordinator",
               "Coordinator",
               "Coordinator"
        };
        spoPost = new String[]{

                "Payal joshi",
                "Diksha giri",
                "Utsav Talwar",
                "Aayush",
                "Chaitanya",
                "Avinash",
                "Mukul",
                "Kunal",
                "Akarshit"
                //"wow\nDeveloper"
        };

        picture=new int[]{
                R.drawable.dev_payal,
                R.drawable.dev_diksha,
                R.drawable.app_utsav,
                R.drawable.app_aayush,
                R.drawable.app_chaitanya,
                R.drawable.app_avinash,
                R.drawable.app_mukul,
                R.drawable.app_kunal,
                R.drawable.app_akarshit
        };


        for (int i = 0; i < picture.length; i++) {
            sponsor_card = new Develop(spoHead[i],spoPost[i],picture[i]);
            develops.add(sponsor_card);

        }
        return develops;
    }}