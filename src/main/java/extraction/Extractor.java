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
    private boolean retweet = false;
    private boolean negate = false;
    private int negateCounter = 0;
    private String punctuations = ".,!?";
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
            retweet=false;
            negate = false;
            negateCounter = 0;
            Document document = cursor.next();
            String text = document.getString("text");
            Double gross = document.getDouble("gross");
            String query = document.getString("query");
            String user = document.getString("userName");
            Double theaterCount = document.getDouble("theater_count");
            Integer favorites = document.getInteger("favoriteCount");
            //account for thanksgiving
            int daysOpened = 3;
            if(document.getInteger("days")!=null && document.getInteger("days") != 3){
                daysOpened = 5;
            }
            MovieInfo temp = new MovieInfo(query, gross, daysOpened, theaterCount);
            if (!movies.contains(temp)){
                System.out.println(query);
                movies.add(temp);
            } else{
                temp = movies.get(movies.indexOf(temp));
            }
            temp.setNumTweets(temp.getNumTweets()+1);
            temp.increaseFavorite(favorites);
            String[] tweetArray = text.split("\\s");
            //If it is a retweet, count up retweets.
            if (text.startsWith("RT @")){
                retweet=true;
                temp.setNumRts(temp.getNumRts()+1);
            }
            for (int i = 0; i < tweetArray.length; i++) {
                if (negateCounter>=2){
                    negate = false;
                    negateCounter = 0;
                }
                if(negate) {
                    negateCounter++;
                }
                temp.increaseWordCount();
                //go through characters in tweet to count punctuation and capital letters
                if(!tweetArray[i].equals("RT") || !tweetArray[i].startsWith("@") || !tweetArray[i].startsWith("#")) {
                    for (int j = 0; j < tweetArray[i].length(); j++) {
                        temp.increaseCharacter();
                        char tempChar = tweetArray[i].charAt(j);
                        if (Character.isUpperCase(tempChar))
                            temp.increaseCapital();
                        else if (punctuations.contains(Character.toString(tempChar)))
                            temp.increasePunctuation();
                    }
                }
                if(tweetArray[i].toLowerCase().equals("no") || tweetArray[i].toLowerCase().equals("not")){
                    negate = true;
                    continue;
                }
                countWordTotal(tweetArray[i], temp);
                if(!retweet) {
                    temp.increaseWordCountNoRetweets();
                    countWordNoRetweets(tweetArray[i], temp);
                }
            }


            SimpleTweet tweet = new SimpleTweet(user, query, text);
            tweets.add(tweet);
        }

        MongoHelper mongoMovies = new MongoHelper("movies", "movies");

        int countMovies = 0;
        for(MovieInfo movie: movies){
            movie.normalizeValues();
            System.out.println(movie.toString());
            String jsonString = JsonHelper.makeJson(movie);
            mongoMovies.getCollection().insertOne(Document.parse(jsonString));
            countMovies++;
        }
        System.out.println();
        System.out.println("Number of movies = " + countMovies);
    }

    /*
    HELPER METHODS
     */

    public void countWordTotal(String text, MovieInfo movie){
        if (text.startsWith("\uD83D")){
            movie.increaseEmoji();
        }
        if (positiveWords.contains(text.toLowerCase()) &&
                !movie.getQuery().toLowerCase().contains(text.toLowerCase())){
            if(!negate)
                movie.increasePositive();
            else
                movie.increaseNegative();
        }
        if (negativeWords.contains(text.toLowerCase())
                && !movie.getQuery().toLowerCase().contains(text.toLowerCase())){
            if(!negate)
                movie.increaseNegative();
            else
                movie.increasePositive();
        }
    }

    public void countWordNoRetweets(String text, MovieInfo movie){
        if (positiveWords.contains(text.toLowerCase()) &&
                !movie.getQuery().toLowerCase().contains(text.toLowerCase())){
            if(!negate)
                movie.increasePositiveNoRetweets();
            else
                movie.increaseNegativeNoRetweets();
        }
        if (negativeWords.contains(text.toLowerCase()) &&
                !movie.getQuery().toLowerCase().contains(text.toLowerCase())){
            if(!negate)
                movie.increaseNegativeNoRetweets();
            else
                movie.increasePositiveNoRetweets();
        }
    }

}
