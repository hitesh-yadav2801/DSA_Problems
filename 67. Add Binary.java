class Solution {
    public String addBinary(String a, String b) {
        StringBuilder str = new StringBuilder();
        int l1 = a.length();
        int l2 = b.length();
        int carry = 0;
        int i = 0;
        while(i < l1 || i < l2 || carry != 0){
            int x = 0;
            if(i < l1 && a.charAt(l1 - 1 - i) == '1') x = 1;
            int y = 0;
            if(i < l2 && b.charAt(l2 - 1 - i) == '1') y = 1;

            int temp = (x + y + carry) % 2;
            str.append(Integer.toString(temp));
            carry = (x + y + carry) / 2;
            i++;
        }
        return str.reverse().toString();
    }
}
