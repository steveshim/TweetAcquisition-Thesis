
public class Tester {
    public static void main(String[] args){
        String test = "Hello World !!! adsffa ?!?..";
        int cCount = 0;
        int pCount = 0;
        int uCount = 0;
        String punctuations = ".,!?";
        String[] testa = test.split("\\s");
        for (int i=0; i<testa.length; i++){
            for (int j=0; j<testa[i].length(); j++){
                cCount++;
                if(Character.isUpperCase(testa[i].charAt(j)))
                    uCount++;
                if(punctuations.contains(Character.toString(testa[i].charAt(j))))
                    pCount++;
            }
        }
        System.out.println(cCount);
        System.out.println(pCount);
        System.out.println(uCount);
    }
}
