// Last updated: 7/10/2025, 8:57:28 AM
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
         return dfs(nums, 0, target, new HashMap<>());
    }
    private int dfs(int[] nums, int index, int target, Map<String, Integer> memo) {
        if (index == nums.length) {
            return target == 0 ? 1 : 0;
        }
        String key = index + "," + target;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int add = dfs(nums, index + 1, target - nums[index], memo);
        int subtract = dfs(nums, index + 1, target + nums[index], memo);
        memo.put(key, add + subtract);
        return add + subtract;
    }
}