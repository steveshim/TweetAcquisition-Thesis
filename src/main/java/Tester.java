
public class Tester {
    public static void main(String[] args){
        String test = "This is not a bad movie fdasf";
        boolean negate = false;
        int negateCounter = 0;
        int cCount = 0;
        String[] testa = test.split("\\s");
        for (int i=0; i<testa.length; i++){
            if (negateCounter>=2){
                negate = false;
            }
            if (testa[i].toLowerCase().equals("no") || testa[i].toLowerCase().equals("not")){
                negate = true;
                continue;
            }
            if (negate){
                negateCounter++;
                System.out.println(testa[i]);
                if (testa[i].toLowerCase().equals("good")) {
                    negate=false;
                    cCount--;
                }
            } else{
                if (testa[i].toLowerCase().equals("good"))
                    cCount++;
            }
        }
        System.out.println(cCount);
    }
}
