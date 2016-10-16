import acquisition.Collector;
import acquisition.Source;
import model.TwitterResponse;

import java.util.Collection;

public class CollectorApp {

    public static void main(String[] args){

        Collector collector = new Collector();
        Source source = new Source(Long.MAX_VALUE, "#PricelessTheMovie", "2016-10-08");

        while (source.hasNext()){
            Collection<TwitterResponse> tweets = source.next();
            collector.save(tweets);
        }

    }
}
