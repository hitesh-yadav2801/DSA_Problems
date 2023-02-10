import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        ArrayList<String> res = new ArrayList<>();
        res = gss(str);
        System.out.println(res);
    }

    public static ArrayList<String> gss(String str) {
        if(str.length() == 0){
            ArrayList<String> bList = new ArrayList<>();
            bList.add("");
            return bList;
        }
        ArrayList<String> list = gss(str.substring(1));
        ArrayList<String> myList = new ArrayList<>();
        for(String s : list){
            myList.add(s);
        }
        for(String s : list){
            myList.add(str.charAt(0) + s);
        }
        return myList;
    }

}
