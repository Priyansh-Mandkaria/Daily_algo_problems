// Last updated: 10/28/2025, 12:47:26 PM
class Solution {
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] ans = new String[words.length];
        for (String c: words){
            ans[(int)(c.charAt(c.length() - 1) - '1')] = c.substring(0, c.length() - 1);
        }
        return String.join(" ", ans);
    }
}