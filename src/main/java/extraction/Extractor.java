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
    MongoHelper mongo;

    public Extractor(){
        mongo = new MongoHelper("movies", "tweets");
    }

    public void extractInfo(){
        MongoCursor<Document> cursor = mongo.getCollection().find().iterator();

        while(cursor.hasNext()){
            Document document = cursor.next();
            String text = document.getString("text");
            String query = document.getString("query");
            String user = document.getString("userName");
            MovieInfo temp = new MovieInfo(query);
            if (!movies.contains(temp)){
                movies.add(temp);
            } else{
                temp = movies.get(movies.indexOf(temp));
            }
            temp.setNumTweets(1 + temp.getNumTweets());
            countGood(text, temp);
            countGreat(text, temp);
            countBest(text, temp);
            countBad(text, temp);
            countWorst(text, temp);

            SimpleTweet tweet = new SimpleTweet(user, query, text);
            tweets.add(tweet);
        }

        for(MovieInfo movie: movies){
            System.out.println(movie.toString());
        }
    }

    public void countGood(String text, MovieInfo movie){
        if (text.toLowerCase().contains("good")){
            movie.setNumGood(movie.getNumGood() + 1);
        }
    }

    public void countBad(String text, MovieInfo movie){
        if (text.toLowerCase().contains("bad")){
            movie.setNumBad(movie.getNumBad() + 1);
        }
    }

    public void countGreat(String text, MovieInfo movie){
        if (text.toLowerCase().contains("great")){
            movie.setNumGreat(movie.getNumGreat() + 1);
        }
    }

    public void countWorst(String text, MovieInfo movie){
        if (text.toLowerCase().contains("worst")){
            movie.setNumWorst(movie.getNumWorst() + 1);
        }
    }

    public void countBest(String text, MovieInfo movie){
        if (text.toLowerCase().contains("best")){
            movie.setNumBest(movie.getNumBest() + 1);
        }
    }

}
