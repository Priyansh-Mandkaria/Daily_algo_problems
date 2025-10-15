// Last updated: 10/15/2025, 4:24:32 PM
class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder res = new StringBuilder();
        for(int i = words.length-1; i >= 0; i--){
            res.append(words[i]);
            if(i > 0) res.append(" ");// so that no extra will add like in trailing 
        }
        return res.toString();
    }
}