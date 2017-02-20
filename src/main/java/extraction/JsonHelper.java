package extraction;

import model.MovieInfo;

public class JsonHelper {

    public static String makeJson(MovieInfo movie){
        String jsonString = "{'query':'" + movie.getQuery() + "', " +
                "'query_length':" + movie.getQueryLength() + ", " +
                "'gross':" + movie.getGross() + ", " +
                "'theater_count':" + movie.getTheaterCount() + ", " +
                "'retweets':" + movie.getNumRts() + ", " +
                "'tweets':" + movie.getNumTweets() + ", " +
                "'positive':" + movie.getNormPositive() + ", " +
                "'negative':" + movie.getNormNegative() + ", " +
                "'punctuation':" + movie.getNormPunctuation() + ", " +
                "'capital':" + movie.getNormCapital() + ", " +
                "'movie_in_query':" + movie.getHasMovieInQuery() + ", " +
                "'positive_no_retweets':" + movie.getNormPositiveNoRts() + ", " +
                "'negative_no_retweets':" + movie.getNormNegativeNoRts() + ", " +
                "'emoji_count':" + movie.getNormEmojis() + ", " +
                "'favorites_per_tweet':" + ((double)movie.getFavoriteCount()/(double)movie.getNumTweets()) + ", " +
                "'averageTemp':" + movie.getAverageTemp() + ", " +
                "'averageRain':" + movie.getAverageRain() + ", " +
                "'averageSnow':" + movie.getAverageSnow() + ", " +
                "'budget':" + movie.getBudget() + ", " +
                "'daysInTheater':" + movie.getDays() + "}";
        return jsonString;
    }
}
