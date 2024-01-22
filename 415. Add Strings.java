class Solution {
    public String addStrings(String num1, String num2) {
        int n1 = num1.length() - 1, n2 = num2.length() - 1;
        int digit1, digit2;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while(n1 >= 0 || n2 >= 0 || carry > 0){
            digit1 = n1 >= 0 ? num1.charAt(n1) - '0' : 0;
            digit2 = n2 >= 0 ? num2.charAt(n2) - '0' : 0;

            int lastDigit = (digit1 + digit2 + carry) % 10;
            sb.append(lastDigit);
            carry = (digit1 + digit2 + carry) / 10;

            if(n1 >= 0) n1--;
            if(n2 >= 0) n2--;
        }
        sb.reverse();

        return sb.toString();
    }
}
