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

// Better approach using mapping

import java.util.* ;
import java.io.*; 
public class Solution {
	public static int getLongestSubarray(int []nums, int k) {
		int prefixSum = 0;
		int ans = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++){
			prefixSum += nums[i];
			if(prefixSum == k){
				ans = Math.max(ans, i + 1);
			}
			int rsum = prefixSum - k;
			if(map.containsKey(rsum)){
				ans = Math.max(ans, i - map.get(rsum));
			}
			if(!map.containsKey(prefixSum)){
				map.put(prefixSum, i);
			}
		}
		return ans;
	}
}
