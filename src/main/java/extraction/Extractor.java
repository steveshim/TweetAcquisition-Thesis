package extraction;


import com.mongodb.client.MongoCursor;
import model.MovieInfo;
import model.SimpleTweet;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class Extractor {
    private List<SimpleTweet> tweets = new ArrayList<>();
    private List<MovieInfo> movies = new ArrayList<>();

    public void extractInfo(){
        int tweetCounter = 0;
        MongoHelper mongo = new MongoHelper("movies", "tweets");
        MongoCursor<Document> cursor = mongo.getCollection().find().iterator();

        while(cursor.hasNext()){
            Document document = cursor.next();
            String text = document.getString("text");
            String user = document.getString("userName");
            String query = document.getString("query");

            SimpleTweet tweet = new SimpleTweet(user, query, text);
            tweets.add(tweet);
            tweetCounter++;
        }
    }

    public int countGood(String text){
        return 0;
    }

    public int countBad(String text){
        return 0;
    }

    public int countGreat(String text){
        return 0;
    }

    public int countWorst(String text){
        return 0;
    }

    public int countBest(String text){
        return 0;
    }

}
