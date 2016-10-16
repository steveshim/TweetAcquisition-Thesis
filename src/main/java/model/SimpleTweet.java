package model;


public class SimpleTweet {
    String name, query, text;

    public SimpleTweet(String name, String query, String text){
        this.name = name;
        this.query = query;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
