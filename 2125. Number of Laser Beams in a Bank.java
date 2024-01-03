// Naive approach

class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0;
        int ans = 0;
        for(int i = 0; i < bank.length; i++){
            int count = 0;
            String s = bank[i];
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(j) == '1'){
                    count++;
                }
            }
            System.out.println(count);
            ans += prev * count;
            if(count != 0){
                prev = count;
            }
        }
        return ans;
    }
}

// Otimize by adding continue 

class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0;
        int ans = 0;
        for(int i = 0; i < bank.length; i++){
            int count = 0;
            String s = bank[i];
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(j) == '1'){
                    count++;
                }
            }
            if(count == 0){
                continue;
            }
            ans += prev * count;
            prev = count;
        }
        return ans;
    }
}
