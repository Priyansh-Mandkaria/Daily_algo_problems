// Last updated: 7/10/2025, 8:57:06 AM
class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] licensePlateCounts = new int[26];
        for(char c: licensePlate.toCharArray()) {
              if(Character.isAlphabetic(c)) {
                  char ch = Character.toLowerCase(c);
                  licensePlateCounts[ch-'a']++;
              }
        }
        String ans = null;
        for(String s: words) {
            int[] stringCounts = new int[26];
            for(Character c : s.toCharArray()) {
                stringCounts[Character.toLowerCase(c)-'a']++;
            } 
            boolean exist = true;
            for(int i =0; i < 26; i++) {
                
                if(stringCounts[i] < licensePlateCounts[i]) {
                    exist = false;
                    break;
                } 
            }
            if(exist) {
                ans = (ans == null || s.length() < ans.length() ? s : ans);
            }
        }
        return ans;
     }
}