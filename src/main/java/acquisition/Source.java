package acquisition;

import model.TwitterResponse;

import java.util.Collection;
import java.util.Iterator;

public class Source implements Iterator<Collection<TwitterResponse>> {

    private long minId;
    private final String QUERY;


    public Source(long minId, String query){
        System.out.println("Searching for: " + query);
        this.minId = minId;
        this.QUERY = query;
    }

    public Collection<TwitterResponse> next(){
        return null;
    }

    public boolean hasNext(){
        return minId > 0;
    }

    public void remove(){
        throw new UnsupportedOperationException();
    }
}
