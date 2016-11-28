import acquisition.Collector;
import acquisition.Source;
import model.TwitterResponse;

import java.util.Collection;

public class CollectorApp {

    public static void main(String[] args){

        double gross = 74403387.0;
        String mondayDate = "2016-11-21";
        String hashtag = "#FantasticBeasts";
        int days = 5;

        Collector collector = new Collector();
        //Source source = new Source(Long.MAX_VALUE, hashtag, mondayDate, gross);
        Source source = new Source(Long.MAX_VALUE, hashtag, mondayDate, gross, days);

        while (source.hasNext()){
            Collection<TwitterResponse> tweets = source.next();
            collector.save(tweets);
        }

    }
}
