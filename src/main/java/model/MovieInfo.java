package model;


public class MovieInfo {

    private String query;
    private int numTweets=0, numGood=0, numBad=0, numGreat=0, numWorst=0, numBest=0;

    public MovieInfo(String query, int tweets, int good, int great, int best, int bad, int worst){
        this.query = query;
        this.numTweets = tweets;
        this.numGood = good;
        this.numBad = bad;
        this.numGreat = great;
        this.numWorst = worst;
        this.numBest = best;
    }

    public MovieInfo(String query){
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getNumTweets() {
        return numTweets;
    }

    public void setNumTweets(int numTweets) {
        this.numTweets = numTweets;
    }

    public int getNumGood() {
        return numGood;
    }

    public void setNumGood(int numGood) {
        this.numGood = numGood;
    }

    public int getNumBad() {
        return numBad;
    }

    public void setNumBad(int numBad) {
        this.numBad = numBad;
    }

    public int getNumGreat() {
        return numGreat;
    }

    public void setNumGreat(int numGreat) {
        this.numGreat = numGreat;
    }

    public int getNumWorst() {
        return numWorst;
    }

    public void setNumWorst(int numWorst) {
        this.numWorst = numWorst;
    }

    public int getNumBest() {
        return numBest;
    }

    public void setNumBest(int numBest) {
        this.numBest = numBest;
    }

    @Override
    public String toString(){
        return "Movie hashtag is " + query + "\nwith " + numTweets + " tweets."  ;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        MovieInfo tempObject = (MovieInfo) o;
        if (this.query.equals(tempObject.query)){
            return true;
        }
        return false;
    }
}
