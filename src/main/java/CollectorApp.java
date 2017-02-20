import acquisition.Collector;
import acquisition.Source;
import model.TwitterResponse;

import java.util.Collection;

public class CollectorApp {

    public static void main(String[] args){

        double gross = 4350000;
        double budget = 40;
        String mondayDate = "2017-02-20";
        String hashtag = "#CureForWellness";
        int days = 3;
        double theaterCount = 333;
        double averageTemp = 47;
        double averageRain = 0.40375;
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
