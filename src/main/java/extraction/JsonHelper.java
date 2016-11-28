package extraction;

import model.MovieInfo;

public class JsonHelper {

    public static String makeJson(MovieInfo movie){
        String jsonString = "{'query':'" + movie.getQuery() + "', " +
                "'gross':" + movie.getGross() + ", " +
                "'retweets':" + movie.getNumRts() + ", " +
                "'tweets':" + movie.getNumTweets() + ", " +
                "'positive':" + movie.getNormPositive() + ", " +
                "'negative':" + movie.getNormNegative() + ", " +
                "'movie_in_query':" + movie.getHasMovieInQuery() + ", " +
                "'positive_no_retweets':" + movie.getNormPositiveNoRts() + ", " +
                "'negative_no_retweets':" + movie.getNormNegativeNoRts() + ", " +
                "'daysInTheater':" + movie.getDays() + "}";
        return jsonString;
    }
}
