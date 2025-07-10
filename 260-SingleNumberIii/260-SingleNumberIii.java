// Last updated: 7/10/2025, 8:58:03 AM
class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;// we are using Xor property to solve this problem that a ^ a //=0 and a ^ 0 = a // a ^ b ^ a = b  
        }
        int bitmanipulation = xor & (-xor);
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & bitmanipulation) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}