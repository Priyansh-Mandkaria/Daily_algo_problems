// Last updated: 10/18/2025, 11:11:31 AM
class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0, prev = (int)-1e9;
        for (int x : nums) {
            int l = Math.max(x - k, prev + 1);
            if (l <= x + k) {
                prev = l;
                ans++;
            }
        }
        return ans;
    }
}