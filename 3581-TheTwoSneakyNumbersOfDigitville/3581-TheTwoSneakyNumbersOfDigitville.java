// Last updated: 7/10/2025, 8:50:37 AM
class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            xor ^= i;
        }
        int diff = xor & -xor;
        int x = 0, y = 0;
        for (int num : nums) {
            if ((num & diff) == 0) x ^= num;
            else y ^= num;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            if ((i & diff) == 0) x ^= i;
            else y ^= i;
        }
        return new int[] {x, y};
    }
}