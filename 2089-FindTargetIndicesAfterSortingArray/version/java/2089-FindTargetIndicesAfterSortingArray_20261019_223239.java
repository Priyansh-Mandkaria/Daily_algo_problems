// Last updated: 10/19/2026, 10:32:39 PM
1class Solution {
2    public List<Integer> targetIndices(int[] nums, int target) {
3        int less = 0, equal = 0;
4        for (int x : nums) {
5            if (x < target) less++;
6            else if (x == target) equal++;
7        }
8        List<Integer> ans = new ArrayList<>();
9        for (int i = 0; i < equal; i++) {
10            ans.add(less + i);
11        }
12        return ans;
13    }
14}