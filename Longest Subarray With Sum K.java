// Brute force

import java.util.* ;


import java.io.*; 
public class Solution {
	public static int getLongestSubarray(int []nums, int k) {
		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for(int j = i; j < nums.length; j++){
				sum += nums[j];
				if(sum == k){
					ans = Math.max(ans, j - i + 1);
				}
			}
		}
		return ans;
	}
}
