class Solution{
    static ArrayList<Integer> candyStore(int candies[],int n,int k){
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(candies);
        int buy = 0, free = n - 1;
        int temp = 0;
        while(buy <= free){
            temp += candies[buy++];
            free = free - k;
        }
        ans.add(temp);
        temp = 0;
        buy = n - 1;
        free = 0;
        while(free <= buy){
            temp += candies[buy--];
            free = free + k;
        }
        ans.add(temp);
        return ans;
    }
}
