// Last updated: 11/26/2025, 6:27:30 PM
class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] ch1 = word1.toCharArray();
        char[] ch2 = word2.toCharArray();
        StringBuilder sb = new StringBuilder();
        int n = word1.length();
        int m = word2.length();
        if(n > m){
            for(int i = 0; i < m; i++){
                sb.append(ch1[i]);
                sb.append(ch2[i]);
            }
            for(int i = m; i < n; i++){
                sb.append(ch1[i]);
            }
        }
        else{
             for(int i = 0; i < n; i++){
                sb.append(ch1[i]);
                sb.append(ch2[i]);
            }
            for(int i = n; i < m; i++){
                sb.append(ch2[i]);
            }
        }
        return sb.toString();
    }
}