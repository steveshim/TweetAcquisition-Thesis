import acquisition.Collector;
import acquisition.Source;
import model.TwitterResponse;

import java.util.Collection;

public class CollectorApp {

    public static void main(String[] args){

        double gross = 33377060;
        double budget = 4.5;
        String mondayDate = "2017-02-27";
        String hashtag = "#GetOut";
        int days = 3;
        double theaterCount = 2781;
        double averageTemp = 54.75 ;
        double averageRain = 0.01875;
        double averageSnow = 0;

        Collector collector = new Collector();
        //Source source = new Source(Long.MAX_VALUE, hashtag, mondayDate, gross);
        Source source = new Source(Long.MAX_VALUE, hashtag, mondayDate, gross, days,
                theaterCount, averageTemp, averageRain, averageSnow, budget);

        while (source.hasNext()){
            Collection<TwitterResponse> tweets = source.next();
            collector.save(tweets);
        }

    }
}
