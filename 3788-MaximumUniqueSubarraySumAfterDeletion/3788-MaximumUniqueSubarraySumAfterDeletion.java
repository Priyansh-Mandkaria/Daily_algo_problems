// Last updated: 7/26/2025, 12:03:53 PM
class Solution {
    public int maxSum(int[] nums) {
        boolean allNegative = true;
        int maxValue = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n >= 0) {
                allNegative = false;
            }
            if (n > maxValue) {
                maxValue = n;
            }
        }
        if (allNegative)
            return maxValue;
        Set<Integer> unique = new HashSet<>();
        for (int n : nums) {
            unique.add(n);
        }
        int sum = 0;
        for (int val : unique) {
            if (val > 0) {
                sum += val;
            }
        }
        return sum;
    }
}
