// Last updated: 7/10/2025, 8:55:52 AM
class Solution {
   public boolean isGoodArray(int[] nums) {
        return gcdArray(nums) == 1;
    } 
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    private int gcdArray(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = gcd(result, nums[i]);
            if (result == 1) {
                return 1;
            }
        }
        return result;
    }    
}