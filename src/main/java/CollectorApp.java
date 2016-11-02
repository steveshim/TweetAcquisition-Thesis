import acquisition.Collector;
import acquisition.Source;
import model.TwitterResponse;

import java.util.Collection;

public class CollectorApp {

    public static void main(String[] args){

        int gross = 0;
        String mondayDate = "2016-10-31";
        String hashtag = "#GimmeDanger";

        Collector collector = new Collector();
        Source source = new Source(Long.MAX_VALUE, hashtag, mondayDate, gross);

        while (source.hasNext()){
            Collection<TwitterResponse> tweets = source.next();
            collector.save(tweets);
        }

    }
}
