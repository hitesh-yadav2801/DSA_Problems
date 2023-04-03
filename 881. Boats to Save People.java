class Solution {
    public int numRescueBoats(int[] people, int limit) {
    int n = people.length;
    int ans = 0;
    Arrays.sort(people);
    int left = 0;
    int right = n - 1;
    while(left <= right){
        int sum = people[left] + people[right];
        if(sum <= limit){
            ans++;
            left++;
            right--;
        } else {
            right--;
            ans++;
        }
    }
    return ans;
    }
}
