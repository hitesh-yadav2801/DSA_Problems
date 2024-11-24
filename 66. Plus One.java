class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int carry = 1;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = n - 1; i >= 0; i--){
            int sum = digits[i] + carry;
            list.add(sum % 10);
            carry = sum / 10;
        }
        if(carry == 1){
            list.add(1);
        }
        int[] ans = new int[list.size()];
        Collections.reverse(list);
        for(int i = 0; i < ans.length; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}
