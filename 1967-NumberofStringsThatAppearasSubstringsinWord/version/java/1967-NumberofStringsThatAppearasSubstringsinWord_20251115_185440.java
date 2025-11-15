// Last updated: 11/15/2025, 6:54:40 PM
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