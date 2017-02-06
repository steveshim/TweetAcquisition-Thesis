package model;

public class TwitterResponse {
    private long id;
    private int favoriteCount;
    private int retweetCount;
    private int days;
    private double theater_count;
    private double gross;
    private String userName, text, date, source, twitterQuery;

    public TwitterResponse(long id, int favoriteCount, int retweetCount, String userName,
                           String text, String date, String source, String twitterQuery, double gross, int days, double theater_count){
        super();
        this.id = id;
        this.favoriteCount = favoriteCount;
        this.retweetCount = retweetCount;
        this.userName = userName;
        this.text = text;
        this.date = date;
        this.source = source;
        this.twitterQuery = twitterQuery;
        this.gross = gross;
        this.days = days;
        this.theater_count = theater_count;
    }

    public int getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(int favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public int getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(int retweetCount) {
        this.retweetCount = retweetCount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTwitterQuery() {
        return twitterQuery;
    }

    public void setTwitterQuery(String twitterQuery) {
        this.twitterQuery = twitterQuery;
    }

    public double getGross() {
        return gross;
    }

    public void setGross(double gross) {
        this.gross = gross;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double getTheater_count() {
        return theater_count;
    }

    public void setTheater_count(double theater_count) {
        this.theater_count = theater_count;
    }

    @Override
    public int hashCode(){
        return 0;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        TwitterResponse tempObject = (TwitterResponse) o;
        if (this.text.equals(tempObject.text)){
            return true;
        }
        return false;
    }
}
