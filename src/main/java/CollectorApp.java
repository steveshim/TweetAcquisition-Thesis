import acquisition.Collector;
import acquisition.Source;
import model.TwitterResponse;

import java.util.Collection;

public class CollectorApp {

    public static void main(String[] args){

        double gross = 85058311;
        String mondayDate = "2016-11-07";
        String hashtag = "#DoctorStrange";

        Collector collector = new Collector();
        Source source = new Source(Long.MAX_VALUE, hashtag, mondayDate, gross);

        while (source.hasNext()){
            Collection<TwitterResponse> tweets = source.next();
            collector.save(tweets);
        }

    }
}
