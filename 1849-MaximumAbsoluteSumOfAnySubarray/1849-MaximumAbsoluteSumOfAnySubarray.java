// Last updated: 7/10/2025, 8:54:40 AM
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int posMax = nums[0];
        int negMax = nums[0];
        int prevNum = nums[0];
        for(int i=1; i<nums.length; i++) {
            prevNum += nums[i];
            if(prevNum < 0 && negMax > prevNum) {
                negMax = prevNum;
            }

            if(prevNum >= 0 && posMax < prevNum) {
                posMax = prevNum;
            }
        }

        return Math.max(Math.abs(negMax), Math.max(posMax, posMax-negMax));
    }
}