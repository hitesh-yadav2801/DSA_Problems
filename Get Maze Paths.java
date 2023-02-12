import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        // int sr = scn.nextInt();
        // int sc = scn.nextInt();
        int dr = scn.nextInt();
        int dc = scn.nextInt();
        ArrayList<String> res = getMazePaths(1, 1, dr, dc);
        System.out.println(res);
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        
        if(sr == dr && sc == dc){
            ArrayList<String> emptyList = new ArrayList<>();
            emptyList.add("");
            return emptyList;
        }
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        if(sc < dc){
            list1 = getMazePaths(sr, sc + 1, dr, dc);
        }
        if(sr < dr){
           list2 = getMazePaths(sr + 1, sc, dr, dc);
        }
        
        ArrayList<String> myList = new ArrayList<>();
        for(String s : list1){
            myList.add("h" + s);
        }
        for(String s : list2){
            myList.add("v" + s);
        }
        return myList;
    }

}
