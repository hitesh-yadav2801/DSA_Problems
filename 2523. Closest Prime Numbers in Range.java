// Not optimal

class Solution {
    public int[] closestPrimes(int left, int right) {
        List<Integer> primes = new ArrayList<>();
        for(int i = left; i <= right; i++){
            int count = 0;
            for(int j = 1; j * j <= i; j++){
                if(i % j == 0){
                    count++;
                    if((i/j) != j) count++;
                }
                if(count > 2) break;
            }
            if(count == 2){
                primes.add(i);
            }
        }
        
        int a = 0;
        int b = Integer.MAX_VALUE;
        for(int i = 0; i < primes.size() - 1; i++){
            if(primes.get(i + 1) - primes.get(i) < (b - a)){
                a = primes.get(i);
                b = primes.get(i + 1);
            }
        }
        if(a == 0 && b == Integer.MAX_VALUE){
            return new int[]{-1,-1};
        }
        return new int[]{a, b};
    }
}
