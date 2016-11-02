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
            Double gross = document.getDouble("gross");
            String query = document.getString("query");
            String user = document.getString("userName");
            MovieInfo temp = new MovieInfo(query, gross);
            if (!movies.contains(temp)){
                movies.add(temp);
            } else{
                temp = movies.get(movies.indexOf(temp));
            }
            temp.setNumTweets(temp.getNumTweets()+1);
            String[] tweetArray = text.split("\\s");
            for (int i=0; i<tweetArray.length; i++){
                countGood(tweetArray[i], temp);
                countGreat(tweetArray[i], temp);
                countBest(tweetArray[i], temp);
                countBad(tweetArray[i], temp);
                countWorst(tweetArray[i], temp);
            }


            SimpleTweet tweet = new SimpleTweet(user, query, text);
            tweets.add(tweet);
        }

        MongoHelper mongoMovies = new MongoHelper("movies", "movies");

        for(MovieInfo movie: movies){
            movie.normalize();
            System.out.println(movie.toString());
            String jsonString = "{'query':'" + movie.getQuery() + "', " +
                    "'gross':" + movie.getGross() + ", " +
                    "'tweets':" + movie.getNumTweets() + ", " +
                    "'good':" + movie.getNormGood() + ", " +
                    "'great':" + movie.getNormGreat() + ", " +
                    "'best':" + movie.getNormBest() + ", " +
                    "'bad':" + movie.getNormBad() + ", " +
                    "'worst':" + movie.getNormWorst() + "}";
            mongoMovies.getCollection().insertOne(Document.parse(jsonString));
        }
    }

    public void countGood(String text, MovieInfo movie){
        if (text.toLowerCase().contains("good")){
            movie.increaseGood();
        }
    }

    public void countBad(String text, MovieInfo movie){
        if (text.toLowerCase().contains("bad")){
            movie.increaseBad();
        }
    }

    public void countGreat(String text, MovieInfo movie){
        if (text.toLowerCase().contains("great")){
            movie.increaseGreat();
        }
    }

    public void countWorst(String text, MovieInfo movie){
        if (text.toLowerCase().contains("worst")){
            movie.increaseWorst();
        }
    }

    public void countBest(String text, MovieInfo movie){
        if (text.toLowerCase().contains("best")){
            movie.increaseBest();
        }
    }

}
