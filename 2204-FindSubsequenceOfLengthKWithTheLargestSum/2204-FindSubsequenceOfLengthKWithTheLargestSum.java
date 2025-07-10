// Last updated: 7/10/2025, 8:53:45 AM
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[] sorted = Arrays.copyOf(nums, n);
        Arrays.sort(sorted);
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = n - k; i < n; i++) {
            freq.put(sorted[i], freq.getOrDefault(sorted[i], 0) + 1);
        }
        int[] result = new int[k];
        int idx = 0;
        for (int num : nums) {
            if (freq.containsKey(num) && freq.get(num) > 0) {
                result[idx++] = num;
                freq.put(num, freq.get(num) - 1);
                if (idx == k) break;
            }
        }
        return result;
    }
}