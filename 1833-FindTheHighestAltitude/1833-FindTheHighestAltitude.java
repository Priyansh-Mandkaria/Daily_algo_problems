// Last updated: 7/10/2025, 8:54:42 AM
class Solution {
    public int largestAltitude(int[] gain) {
        int currentAltitude = 0 ;
        int maxAltitude = 0 ;
        for(int i = 0; i < gain.length ; i++){
            currentAltitude += gain[i];
            if(currentAltitude > maxAltitude){
                maxAltitude = currentAltitude;
            }
        }
        return maxAltitude;
    }
}