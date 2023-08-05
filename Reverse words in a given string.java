class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String s)
    {
        String[] word = s.split("\\.");
        StringBuilder ans = new StringBuilder();
        int n = word.length;
        for(int i = n - 1; i >= 0; i--){
            ans.append(word[i]);
            if(i != 0){
                ans.append(".");
            }
        }
        String str = ans.toString();
        return str;
    }
}
