/* Problem Statement : 
Given a really large number N, break it into 3 whole numbers such that they sum up to the original
number and find the number of ways to do so. Since this number can be very large, return it modulo 109+7. 

*/


class Solution{
    int waysToBreakNumber(int N){
        long m = 1000000007;
        long a = (N+1) % m;
        long b = (N+2) % m;
        
        int ans =(int)(((a*b)/2)%m);
        return ans;
    }
}
