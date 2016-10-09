import acquisition.Source;

public class CollectorApp {

    public static void main(String[] args){
        Source source = new Source(Long.MAX_VALUE, "#TheRevenant", "2015-12-25");

        while (source.hasNext()){
            source.next();
        }
    }
}
