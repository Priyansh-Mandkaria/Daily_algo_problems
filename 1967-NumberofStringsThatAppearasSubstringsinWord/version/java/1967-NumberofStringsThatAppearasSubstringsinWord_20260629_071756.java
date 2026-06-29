// Last updated: 6/29/2026, 7:17:56 AM
1class Solution {
2    public int numOfStrings(String[] patterns, String word) {
3       int count = 0;
4       for(int i = 0 ; i < patterns.length ; i++){
5            if(word.contains(patterns[i])){
6                count++;
7            }
8       } 
9       return count;
10    }
11}