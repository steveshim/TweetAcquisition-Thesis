package acquisition;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import model.TwitterResponse;
import org.bson.Document;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Collector {

    MongoClient mongoClient;
    MongoDatabase db;
    MongoCollection<Document> collection;

    public Collector(){
        mongoClient = new MongoClient();
        db = mongoClient.getDatabase("movies");
        collection = db.getCollection("tweets");
    }

    public void save(Collection<TwitterResponse> data){
        if (data.size() == 0 || data == null)
            return;

        System.out.println("Size of data is " + data.size());

        List<Document> documents = data.stream().map(item -> new Document().
                append("tweetId", item.getId()).append("favoriteCount", item.getFavoriteCount()).
                append("retweetCount", item.getRetweetCount()).append("userName", item.getUserName()).
                append("text", item.getText()).append("date", item.getDate()).append("source", item.getSource()))
                .collect(Collectors.toList());

        collection.insertMany(documents);
    }

}
