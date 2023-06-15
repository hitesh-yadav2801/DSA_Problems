class Solution {
    public double myPow(double x, int n) {
        double res = 1.0;
        long num = n;
        if(n < 0) num = -1 * num;
        while(num > 0){
            if(num % 2 == 1){
                res = res * x;
                num--;
            }
            x = x * x;
            num /= 2;
        }
        if(n < 0) res = (double)1.0 / res;
        return res;
    }
}
