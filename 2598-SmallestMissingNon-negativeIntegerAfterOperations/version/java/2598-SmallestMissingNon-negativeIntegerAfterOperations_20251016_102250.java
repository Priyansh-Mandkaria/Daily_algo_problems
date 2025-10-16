// Last updated: 10/16/2025, 10:22:50 AM
class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] remainderCount = new int[value];
        for (int num : nums) {
            int rem = ((num % value) + value) % value;
            remainderCount[rem]++;
        }
        int result = 0;
        while (remainderCount[result % value] > 0) {
            remainderCount[result % value]--;
            result++;
        }
        return result;
    }
}