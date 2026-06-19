// Last updated: 6/19/2026, 8:54:22 AM
1class Solution {
2    public int largestAltitude(int[] gain) {
3        int currentAltitude = 0 ;
4        int maxAltitude = 0 ;
5        for(int i = 0; i < gain.length ; i++){
6            currentAltitude += gain[i];
7            if(currentAltitude > maxAltitude){
8                maxAltitude = currentAltitude;
9            }
10        }
11        return maxAltitude;
12    }
13}