// Last updated: 7/10/2025, 8:52:51 AM
class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xor1 = 0;
        int xor2 = 0;
        for (int num : nums1) {
            xor1 ^= num;
        }
        for (int num : nums2) {
            xor2 ^= num;
        }
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 % 2 == 1 && n2 % 2 == 1) {
            return xor1 ^ xor2;
        } else if (n1 % 2 == 1) {
            return xor2;
        } else if (n2 % 2 == 1) {
            return xor1;
        } else {
            return 0;
        }
    }
}