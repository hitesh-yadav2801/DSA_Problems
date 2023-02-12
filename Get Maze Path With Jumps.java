import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
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
    // base case
    if (sr == dr && sc == dc) {
      ArrayList<String> emptyList = new ArrayList<>();
      emptyList.add("");
      return emptyList;
    }


    ArrayList<String> myList = new ArrayList<>();

    // horizontal moves
    for (int hm = 1; hm <= dc - sc; hm++) {
      ArrayList<String> hpaths = getMazePaths(sr, sc + hm, dr, dc);
      for (String hpath : hpaths) {
        myList.add("h" + hm + hpath);
      }
    }

    // vertical moves
    for (int vm = 1; vm <= dr - sr; vm++) {
      ArrayList<String> vpaths = getMazePaths(sr + vm, sc, dr, dc);
      for (String vpath : vpaths) {
        myList.add("v" + vm + vpath);
      }
    }

    // diagonal moves
    for (int dm = 1; dm <= dc - sc && dm <= dr - sr; dm++) {
      ArrayList<String> dpaths = getMazePaths(sr + dm, sc + dm, dr, dc);
      for (String dpath : dpaths) {
        myList.add("d" + dm + dpath);
      }
    }
    return myList;
  }

}
