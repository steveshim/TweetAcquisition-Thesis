import acquisition.Collector;
import acquisition.Source;
import model.TwitterResponse;

import java.util.Collection;

public class CollectorApp {

    public static void main(String[] args){

        double gross = 3775596;
        String mondayDate = "2017-02-06";
        String hashtag = "#TheSpaceBetweenUs";
        int days = 3;
        double theaterCount = 2812;
        double averageTemp = 0;
        double averageRain = 0;
        double averageSnow = 0;

        Collector collector = new Collector();
        //Source source = new Source(Long.MAX_VALUE, hashtag, mondayDate, gross);
        Source source = new Source(Long.MAX_VALUE, hashtag, mondayDate, gross, days,
                theaterCount, averageTemp, averageRain, averageSnow);

        while (source.hasNext()){
            Collection<TwitterResponse> tweets = source.next();
            collector.save(tweets);
        }

    }
}
