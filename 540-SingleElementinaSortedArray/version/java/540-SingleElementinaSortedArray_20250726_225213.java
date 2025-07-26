// Last updated: 7/26/2025, 10:52:13 PM
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int xor = 0;
        for(int x : nums) xor ^= x;
        return xor;
    }
}