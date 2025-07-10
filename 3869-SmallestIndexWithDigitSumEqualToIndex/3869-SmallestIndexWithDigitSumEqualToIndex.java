// Last updated: 7/10/2025, 8:49:16 AM
class Solution {
    public int smallestIndex(int[] nums) {
         return IntStream.range(0, nums.length)
                .filter(i -> String.valueOf(nums[i]).chars().map(c -> c - '0').sum() == i)
                .findFirst()
                .orElse(-1);
    }
}