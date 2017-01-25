import com.mongodb.client.MongoCursor;
import extraction.MongoHelper;
import org.bson.Document;

public class Tester {
    public static void main(String[] args){
        MongoHelper mongo = new MongoHelper("movies", "tweets");
        MongoCursor<Document> cursor = mongo.getCollection().find().iterator();
        while(cursor.hasNext()){
            Document document = cursor.next();
            String text = document.getString("text");
            String[] tweetArray = text.split("\\s");
            for (int i = 0; i < tweetArray.length; i++) {
                String emoji = "x1f602";
                if(tweetArray[i].toLowerCase().startsWith("\uD83D")){
                    System.out.println(text);
                    break;
                }
            }

        }
    }
}
