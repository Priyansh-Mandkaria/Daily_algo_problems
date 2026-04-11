// Last updated: 4/11/2026, 8:45:52 AM
1class Solution {
2    public int minimumDistance(int[] nums) {
3        Map<Integer, List<Integer>> mp = new HashMap<>();
4        int n = nums.length;
5        for (int i = 0; i < n; i++) {
6            mp.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
7        }
8        int mini = Integer.MAX_VALUE;
9        for (List<Integer> temp : mp.values()) {
10            int m = temp.size();
11            if (m >= 3) {
12                for (int i = 0; i < m - 2; i++) {
13                    int a = temp.get(i);
14                    int b = temp.get(i + 1);
15                    int c = temp.get(i + 2);
16                    int diff = 2 * (Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c)));
17                    mini = Math.min(mini, diff);
18                }
19            }
20        }
21        return mini == Integer.MAX_VALUE ? -1 : mini;
22    }
23}