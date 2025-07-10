// Last updated: 7/10/2025, 8:59:43 AM
class Solution {
    public int removeElement(int[] nums, int val) {
        int newLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[newLength] = nums[i];
                newLength++;
            }
        }
        return newLength;
    }
}