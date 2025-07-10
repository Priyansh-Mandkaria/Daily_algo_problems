// Last updated: 7/10/2025, 8:59:32 AM
class Solution {
    public int searchInsert(int[] nums, int target) {
        for( int i = 0 ; i < nums.length ; i++){
            if( nums[i] == target){
                return i;
            }
            else if ( nums[i] > target){
                return i;
            }
        }
        return nums.length;
    }
}