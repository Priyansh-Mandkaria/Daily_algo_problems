// Last updated: 7/10/2025, 8:59:45 AM
class Solution {
    public int removeDuplicates(int[] nums) {
    int s = 0;
    for (int i = 1; i < nums.length; i++) {
        if (nums[i] != nums[s]) {
            s++;
            nums[s] = nums[i];
        }
    }
    return s+1;
    }
}