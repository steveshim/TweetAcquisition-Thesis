package extraction;

import model.MovieInfo;

public class JsonHelper {

    public static String makeJson(MovieInfo movie){
        String jsonString = "{'query':'" + movie.getQuery() + "', " +
                "'gross':" + movie.getGross() + ", " +
                "'retweets':" + movie.getNumRts() + ", " +
                "'tweets':" + movie.getNumTweets() + ", " +
                "'good':" + movie.getNormGood() + ", " +
                "'great':" + movie.getNormGreat() + ", " +
                "'best':" + movie.getNormBest() + ", " +
                "'bad':" + movie.getNormBad() + ", " +
                "'worst':" + movie.getNormWorst() + "}";
        return jsonString;
    }
}
