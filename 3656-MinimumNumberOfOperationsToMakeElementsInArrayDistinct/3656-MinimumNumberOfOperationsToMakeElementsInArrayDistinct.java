// Last updated: 7/10/2025, 8:50:08 AM
class Solution {
    public int minimumOperations(int[] nums) {
        int freq[] = new int[101];
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }
        int count = 0;
        int numPoint = 0;
        for (int i = 0; i < 101; i++) {
            if (freq[i] > 1) {
                for (int j = 0; j < 3 && numPoint < nums.length; j++)
                    freq[nums[numPoint++]]--;
                count++;
                i--;
            }
        }
        return count;
    }
}