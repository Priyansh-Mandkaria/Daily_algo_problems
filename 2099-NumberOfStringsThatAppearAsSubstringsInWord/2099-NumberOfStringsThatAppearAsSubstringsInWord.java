// Last updated: 7/10/2025, 8:54:04 AM
class Solution {
    public int numOfStrings(String[] patterns, String word) {
       int count = 0;
       for(int i = 0 ; i < patterns.length ; i++){
            if(word.contains(patterns[i])){
                count++;
            }
       } 
       return count;
    }
}