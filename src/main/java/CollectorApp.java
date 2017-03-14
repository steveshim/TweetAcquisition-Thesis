import acquisition.Collector;
import acquisition.Source;
import model.TwitterResponse;

import java.util.Collection;

public class CollectorApp {

    public static void main(String[] args){

        double gross = 61025472;
        double budget = 185;
        String mondayDate = "2017-03-13";
        String hashtag = "#kongskullisland";
        int days = 3;
        double theaterCount = 3846;
        double averageTemp = 48.75;
        double averageRain = 0.08875;
        double averageSnow = 0.2625;

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
