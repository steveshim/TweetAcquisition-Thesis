import acquisition.Collector;
import acquisition.Source;
import model.TwitterResponse;

import java.util.Collection;

public class CollectorApp {

    public static void main(String[] args){

        double gross = 3471316;
        String mondayDate = "2017-01-30";
        String hashtag = "#GoldMovie";
        int days = 3;
        double theaterCount = 2000;

        Collector collector = new Collector();
        //Source source = new Source(Long.MAX_VALUE, hashtag, mondayDate, gross);
        Source source = new Source(Long.MAX_VALUE, hashtag, mondayDate, gross, days, theaterCount);

        while (source.hasNext()){
            Collection<TwitterResponse> tweets = source.next();
            collector.save(tweets);
        }

    }
}
