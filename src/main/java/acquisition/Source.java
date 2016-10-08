package acquisition;

import com.google.common.collect.Lists;
import model.TwitterResponse;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

public class Source implements Iterator<Collection<TwitterResponse>> {

    private long minId;
    private final String TWITTER_QUERY;
    //date must be in "YYYY-MM-DD" format
    private final String MOVIE_DATE;
    private final String TWITTER_CONSUMER_KEY = System.getenv("CONSUMER_KEY");
    private final String TWITTER_CONSUMER_SECRET = System.getenv("CONSUMER_SECRET");
    private final String TWITTER_ACCESS_TOKEN = System.getenv("ACCESS_TOKEN");
    private final String TWITTER_ACCESS_SECRET = System.getenv("ACCESS_SECRET");


    public Source(long minId, String searchQuery, String date){
        System.out.println("Searching for: " + searchQuery);
        this.minId = minId;
        this.TWITTER_QUERY = searchQuery;
        this.MOVIE_DATE = date;
    }

    public Collection<TwitterResponse> next(){
        List<TwitterResponse> list = Lists.newArrayList();
        ConfigurationBuilder cb = new ConfigurationBuilder();

        cb.setDebugEnabled(true).setOAuthConsumerKey(TWITTER_CONSUMER_KEY)
                .setOAuthConsumerSecret(TWITTER_CONSUMER_SECRET).setOAuthAccessToken(TWITTER_ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(TWITTER_ACCESS_SECRET);
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        Query query = new Query(TWITTER_QUERY);
        query.setLang("en");
        query.setSince(MOVIE_DATE);
        return list;
    }

    public boolean hasNext(){
        return minId > 0;
    }

    public void remove(){
        throw new UnsupportedOperationException();
    }
}
