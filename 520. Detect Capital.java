class Solution {
    public boolean detectCapitalUse(String word) {
        char dummy = word.charAt(0);
        String a = String.valueOf(dummy);
        String dummyChar = a.toString().toUpperCase();
        String sub = word.substring(1);
        String b = sub.toUpperCase();
        String c = sub.toLowerCase();
        if(word.startsWith(dummyChar)){
            if(b.equals(sub)){
                return true;
            } else if(c.equals(sub)){
                return true;
            }
        }
        String dummyWord = word.toLowerCase();
        if(dummyWord.equals(word)) return true;
        return false;
    }
}
