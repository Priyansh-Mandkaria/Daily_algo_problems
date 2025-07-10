// Last updated: 7/10/2025, 8:50:51 AM
class Solution {
    public boolean canAliceWin(int[] nums) {
        int s1 = 0;
        int s2 = 0;
        for(int x : nums){
            if( x < 10){
                s1 += x;
            }
            else if( 10 <= x && x < 100){
                s2 += x;
            }
        }
        if( s1 > s2 || s1 < s2){
            return true;
        }
        return false;
    }
}