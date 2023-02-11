import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> res = getStairPaths(n);
        System.out.println(res);
    }

    public static ArrayList<String> getStairPaths(int n) {
        if(n == 0){
            ArrayList<String> baseList = new ArrayList<>();
            baseList.add("");
            return baseList;
        } else if(n < 0){
            ArrayList<String> baseList = new ArrayList<>();
            return baseList;
        }   
        ArrayList<String> p1 = getStairPaths(n-1);
        ArrayList<String> p2 = getStairPaths(n-2);
        ArrayList<String> p3 = getStairPaths(n-3);
        
        ArrayList<String> paths = new ArrayList<>();
        for(String path : p1){
           paths.add(1 + path);
        }
        for(String path : p2){
           paths.add(2 + path);
        }
        for(String path : p3){
           paths.add(3 + path);
        }
        
        return paths;
    }

}
