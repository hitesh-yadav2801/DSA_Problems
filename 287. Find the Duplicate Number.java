// using extra space and O(n) time

class Solution {
    public int findDuplicate(int[] nums) {
        int[] freq = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            freq[nums[i]]++;
        }
        for(int i = 0; i < nums.length; i++){
            if(freq[i] > 1){
                return i;
            }
        }
        return 0;
    }
}

// without using extra space. slow and fast pointer method

import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution{
    public static int findDuplicate(ArrayList<Integer> arr, int n){
        int slow = arr.get(0);
        int fast = arr.get(0);
        do{
            slow = arr.get(slow);
            fast = arr.get(arr.get(fast));
        } while(slow != fast);
        fast = arr.get(0);
        while(slow != fast){
            slow = arr.get(slow);
            fast = arr.get(fast);
        }
        return slow;
    }
}

