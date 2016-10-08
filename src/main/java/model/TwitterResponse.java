package model;

public class TwitterResponse {
    private long id;
    private int favoriteCount;
    private int retweetCount;
    private String userName, text, date, source;

    public TwitterResponse(long id, int favoriteCount, int retweetCount, String userName,
                           String text, String date, String source){
        super();
        this.id = id;
        this.favoriteCount = favoriteCount;
        this.retweetCount = retweetCount;
        this.userName = userName;
        this.text = text;
        this.date = date;
        this.source = source;
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
