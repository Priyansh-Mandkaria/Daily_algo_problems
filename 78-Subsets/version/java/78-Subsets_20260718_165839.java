// Last updated: 7/18/2026, 4:58:39 PM
1class Solution {
2    public List<List<Integer>> subsets(int[] nums) {
3        List<List<Integer>> result = new ArrayList<>();
4        int n = nums.length;
5        int totalSubsets = 1 << n; 
6        for (int mask = 0; mask < totalSubsets; mask++) {
7            List<Integer> currentSubset = new ArrayList<>();
8            for (int i = 0; i < n; i++) {
9                if ((mask & (1 << i)) != 0) {
10                    currentSubset.add(nums[i]);
11                }
12            }
13            result.add(currentSubset);
14        }
15        return result;
16    }
17}