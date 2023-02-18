import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        printKPC(str, "");
        
    }
    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    
    public static void printKPC(String str, String ans) {
        
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        String roq = str.substring(1);
        
        String code = codes[ch - '0'];
        for(int i = 0; i < code.length(); i++){
            char c = code.charAt(i);
            printKPC(roq, ans + c);
        }
    }

}
