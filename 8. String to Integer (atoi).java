class Solution {
    public int myAtoi(String s) {
        int num = 0;
        int n = s.length();
        int i = 0;
        boolean flag = false;
        while(i < n && s.charAt(i) == ' '){
            i++;
        }
        if(i < n && s.charAt(i) == '-'){
            flag = true;
            i++;
        } else if (i < n && s.charAt(i) == '+'){
            i++;
        }
        if (i < n && ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || s.charAt(i) == '.' || s.charAt(i) == '+' || s.charAt(i) == '-')){
            return 0;
        }
        while(i < n && Character.isDigit(s.charAt(i))){
            int x = s.charAt(i) - '0';
            if(num > (Integer.MAX_VALUE - x) / 10){
                if(flag){
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
            num = num * 10 + x;
            i++;
        }
        if(flag){
            return -num;
        }
        return num;
    }
}
