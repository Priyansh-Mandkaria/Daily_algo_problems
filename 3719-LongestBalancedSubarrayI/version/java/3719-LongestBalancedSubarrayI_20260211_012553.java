// Last updated: 2/11/2026, 1:25:53 AM
1class Solution {
2    public int longestBalanced(int[] nums) {
3        int n = nums.length;
4        int[] balance = new int[n]; 
5        HashMap<Integer, Integer> first = new HashMap<>();
6        int result = 0;
7        for (int l = n - 1; l >= 0; l--) {
8            int x = nums[l];
9            Integer oldpos = first.get(x);
10            if (oldpos != null)
11                balance[oldpos] = 0;
12            first.put(x, l);
13            balance[l] = ((x & 1) == 0) ? 1 : -1;
14            int s = 0;
15            for (int r = l; r < n; r++) {
16                s += balance[r];
17                if (s == 0)
18                    result = Math.max(result, r - l + 1);
19            }
20        }
21        return result;
22    }
23}