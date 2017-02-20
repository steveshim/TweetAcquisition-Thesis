import acquisition.Collector;
import acquisition.Source;
import model.TwitterResponse;

import java.util.Collection;

public class CollectorApp {

    public static void main(String[] args){

        double gross = 53003468;
        double budget = 0;
        String mondayDate = "2017-02-13";
        String hashtag = "#LEGOBatmanMovie";
        int days = 3;
        double theaterCount = 4088;
        double averageTemp = 41.5;
        double averageRain = 0.06;
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
