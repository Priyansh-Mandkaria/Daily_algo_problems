// Last updated: 7/10/2025, 8:53:32 AM
class Solution {
    public int minSwaps(int[] nums) {
       int n = nums.length;
        int k = 0;
        for (int num : nums) {
            if (num == 1) k++;
        }
        if (k == 0 || k == 1) return 0;
        int[] extended = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            extended[i] = nums[i % n];
        }
        int currentOnes = 0;
        for (int i = 0; i < k; i++) {
            if (extended[i] == 1) currentOnes++;
        }
        int maxOnesInWindow = currentOnes;
        for (int i = k; i < 2 * n; i++) {
            if (extended[i - k] == 1) currentOnes--;
            if (extended[i] == 1) currentOnes++;
            maxOnesInWindow = Math.max(maxOnesInWindow, currentOnes);
        }
        return k - maxOnesInWindow; 
    }
}