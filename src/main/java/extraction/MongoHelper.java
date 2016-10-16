package extraction;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoHelper {
    private MongoClient mongo;
    private MongoDatabase mongoDb;
    private MongoCollection<Document> collection;


    public MongoHelper(String database, String collection){
        this.mongo = new MongoClient();
        this.mongoDb = mongo.getDatabase(database);
        this.collection = mongoDb.getCollection(collection);
    }

    public MongoCollection<Document> getCollection(){
        return collection;
    }
}
