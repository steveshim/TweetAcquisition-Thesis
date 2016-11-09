package model;


import java.text.NumberFormat;

public class MovieInfo {

    private String query;
    private int numTweets=0, numRts=0, numGood=0, numBad=0, numGreat=0, numWorst=0, numBest=0;
    private double normGood=0, normBad=0, normGreat=0, normWorst=0, normBest=0;
    private double gross;
    private NumberFormat formatter = NumberFormat.getCurrencyInstance();

    public MovieInfo(String query, int tweets, int good, int great, int best, int bad, int worst){
        this.query = query;
        this.numTweets = tweets;
        this.numGood = good;
        this.numBad = bad;
        this.numGreat = great;
        this.numWorst = worst;
        this.numBest = best;
    }

    public MovieInfo(String query, double gross){
        this.query = query;
        this.gross = gross;
    }

    public void normalize(){
        normGood = ((double)numGood)/((double)numTweets-numRts);
        normBad = ((double)numBad)/((double)numTweets-numRts);
        normWorst = ((double)numWorst)/((double)numTweets-numRts);
        normGreat = ((double)numGreat)/((double)numTweets-numRts);
        normBest = ((double)numBest)/((double)numTweets-numRts);
    }

    public int getNumRts() {
        return numRts;
    }

    public void setNumRts(int numRts) {
        this.numRts = numRts;
    }

    public void increaseGood(){
        numGood++;
    }

    public void increaseGreat(){
        numGreat++;
    }

    public void increaseBest(){
        numBest++;
    }

    public void increaseBad(){
        numBad++;
    }

    public void increaseWorst(){
        numWorst++;
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

    public double getGross() {
        return gross;
    }

    public void setGross(double gross) {
        this.gross = gross;
    }

    public double getNormGood() {
        return normGood;
    }

    public void setNormGood(double normGood) {
        this.normGood = normGood;
    }

    public double getNormBad() {
        return normBad;
    }

    public void setNormBad(double normBad) {
        this.normBad = normBad;
    }

    public double getNormGreat() {
        return normGreat;
    }

    public void setNormGreat(double normGreat) {
        this.normGreat = normGreat;
    }

    public double getNormWorst() {
        return normWorst;
    }

    public void setNormWorst(double normWorst) {
        this.normWorst = normWorst;
    }

    public double getNormBest() {
        return normBest;
    }

    public void setNormBest(double normBest) {
        this.normBest = normBest;
    }

    @Override
    public String toString(){
        return "Movie hashtag is " + query + "\nwith " + numTweets + " tweets.\n"
                + "Number of retweets: " + numRts + "\n"
                + "Grossed " + formatter.format(gross) + " on opening weekend.\n"
                + normGood + " normalized good.\n"
                + normGreat + " normalized great.\n"
                + normBest + " normalized best.\n"
                + normBad + " normalized bad.\n"
                + normWorst + " normalized worst.\n";
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
