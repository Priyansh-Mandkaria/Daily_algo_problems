// Last updated: 7/10/2025, 8:51:01 AM
class Solution {
    public int minimumLength(String s) {
        int count[] = new int[26],  length= 0;
        for (char c:s.toCharArray()) count[c-'a']++;
        for (int i=0;i<count.length;i++){
            if (count[i]>=3) {
                count[i] = count[i]%2==0?2:1;
            }
        }
        for (int c:count) {
            length+=c;}
        return length; 
    }
}