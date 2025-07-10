// Last updated: 7/10/2025, 8:54:09 AM
class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length; 
        int[] ans = new int[2 * n];
        for(int i = 0; i <= nums.length - 1 ; i++){
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }
        return ans;
    }
}