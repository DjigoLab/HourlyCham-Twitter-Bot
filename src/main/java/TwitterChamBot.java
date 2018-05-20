import twitter4j.*;

import java.io.*;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class TwitterChamBot {

    public static void main(String[] args) {
        tweetPics();

    }

    private static void tweetPics() {
        Random r = new Random();
        int countFiles = 0;

        try {

            //Finds a random chameleon Pic
            File folder = new File("C:\\Users\\Djigo\\Pictures\\CuteChams\\");
            countFiles = folder.list().length;
            int n = r.nextInt(countFiles + 1);

            File chamPic = new File("C:\\Users\\Djigo\\Pictures\\CuteChams\\" + n + ".jpg");
            System.out.println(n);
            sendTweet(chamPic);
            //Sleeps for ONE DAY
            System.out.println("Sleeping, see you tomorrow...");

            Thread.sleep(8640 * 10000);

        } catch (InterruptedException e) {
            System.out.println("Sleep failed");
            e.printStackTrace();
        }

    }

    private static void sendTweet(File pic) {
        Twitter twitter = TwitterFactory.getSingleton();

        //Generates text and date
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String text = "Daily Cham! " + dateFormat.format(date);
        StatusUpdate update = new StatusUpdate(text);

        //Uploads pic and sends tweet
        try {
            update.setMedia(pic);
            twitter.updateStatus(update);

        } catch (TwitterException e) {

            e.printStackTrace();
        }
    }

}
