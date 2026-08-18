// Last updated: 8/18/2026, 8:44:40 AM
1class Solution {
2    public int largestInteger(int[] nums, int k) {
3        int[] freq = new int[51];
4        for(int i = 0; i <= nums.length - k; i++) {
5            Set<Integer> set = new HashSet<>();
6            for(int j = i; j < i + k; j++) set.add(nums[j]);
7            for(int key : set) freq[key]++;
8        }
9        for(int i = 50; i >= 0; i--) {
10            if(freq[i] == 1) return i;
11        }
12        return -1;
13    }
14}