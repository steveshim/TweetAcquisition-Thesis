package extraction;


import com.mongodb.client.MongoCursor;
import model.MovieInfo;
import model.SimpleTweet;
import org.bson.Document;

import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Extractor {
    private List<SimpleTweet> tweets = new ArrayList<>();
    private List<MovieInfo> movies = new ArrayList<>();
    private List<String> positiveWords;
    private List<String> negativeWords;
    MongoHelper mongo;

    public Extractor(){
        mongo = new MongoHelper("movies", "tweets");
        try {
            positiveWords = Files.readAllLines(Paths.get(ClassLoader.getSystemResource("positive-words.txt").toURI()));
            negativeWords = Files.readAllLines(Paths.get(ClassLoader.getSystemResource("negative-words.txt").toURI()));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void extractInfo(){
        MongoCursor<Document> cursor = mongo.getCollection().find().iterator();

        while(cursor.hasNext()){
            Document document = cursor.next();
            String text = document.getString("text");
            Double gross = document.getDouble("gross");
            String query = document.getString("query");
            String user = document.getString("userName");
            MovieInfo temp = new MovieInfo(query, gross);
            if (!movies.contains(temp)){
                System.out.println(query);
                movies.add(temp);
            } else{
                temp = movies.get(movies.indexOf(temp));
            }
            temp.setNumTweets(temp.getNumTweets()+1);
            String[] tweetArray = text.split("\\s");
            for (int i = 0; i < tweetArray.length; i++) {
                countWordTotal(tweetArray[i], temp);
            }
            //If it is a retweet, count up retweets.
            if (text.startsWith("RT @")){
                temp.setNumRts(temp.getNumRts()+1);
            } else {
                for (int i = 0; i < tweetArray.length; i++) {
                    countWordNoRetweets(tweetArray[i], temp);
                }
            }

            SimpleTweet tweet = new SimpleTweet(user, query, text);
            tweets.add(tweet);
        }

        MongoHelper mongoMovies = new MongoHelper("movies", "movies");

        for(MovieInfo movie: movies){
            movie.normalizeTotals();
            movie.normalizeNonRetweets();
            System.out.println(movie.toString());
            String jsonString = JsonHelper.makeJson(movie);
            mongoMovies.getCollection().insertOne(Document.parse(jsonString));
        }
    }

    public void countWordTotal(String text, MovieInfo movie){
        if (positiveWords.contains(text.toLowerCase())){
            movie.increasePositive();
        }
        if (negativeWords.contains(text.toLowerCase())){
            movie.increaseNegative();
        }
    }

    public void countWordNoRetweets(String text, MovieInfo movie){
        if (positiveWords.contains(text.toLowerCase())){
            movie.increasePositiveNoRetweets();
        }
        if (negativeWords.contains(text.toLowerCase())){
            movie.increaseNegativeNoRetweets();
        }
    }

}
