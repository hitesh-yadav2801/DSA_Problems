import java.io.*;
	import java.util.*;

	public class Main {

	    public static void main(String[] args) throws Exception {
	        Scanner sc = new Scanner(System.in);
	        int dr = sc.nextInt();
	        int dc = sc.nextInt();
	        printMazePaths(1, 1, dr, dc, "");
	    }

	    // sr - source row
	    // sc - source column
	    // dr - destination row
	    // dc - destination column
	    public static void printMazePaths(int sr, int sc, int dr, int dc, String ans) {
	        
	        if(sr == dc && sc == dc){
	            System.out.println(ans);
	            return;
	        }
	        if(sc < dc){
	            printMazePaths(sr, sc + 1, dr, dc, ans + "h");   
	        }
	        if(sr < dr){
	            printMazePaths(sr + 1, sc, dr, dc, ans + "v");
	        }
	    }
	}
