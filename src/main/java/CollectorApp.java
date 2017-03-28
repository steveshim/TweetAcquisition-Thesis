import acquisition.Collector;
import acquisition.Source;
import model.TwitterResponse;

import java.util.Collection;

public class CollectorApp {

    public static void main(String[] args){

        double gross = 336227;
        double budget = 5;
        String hashtag = "#WilsonMovie";
        double theaterCount = 310;
        int days = 3;
        String mondayDate = "2017-03-27";
        double averageTemp = 54.625;
        double averageRain = 0.1875;
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
