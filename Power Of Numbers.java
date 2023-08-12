//User function Template for Java

class Solution
{
    long mod = 1000000007;
    long power(int n,int r)
    {
      if(n == 0) return 0;
      if(r == 0) return 1;
     
      if(r % 2 == 0){
          long ans = power(n, r / 2);
          return (ans % mod * ans % mod) % mod;
      } else {
           long ans = power(n, (r - 1) / 2);
          return (ans % mod * ans % mod * n % mod ) % mod;
      }
     
    }

}
