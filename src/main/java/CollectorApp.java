import acquisition.Source;

public class CollectorApp {

    public static void main(String[] args){

        Source source = new Source(Long.MAX_VALUE, "#StayPeculiar", "2016-09-30");

        while (source.hasNext()){
            source.next();
        }

    }
}
