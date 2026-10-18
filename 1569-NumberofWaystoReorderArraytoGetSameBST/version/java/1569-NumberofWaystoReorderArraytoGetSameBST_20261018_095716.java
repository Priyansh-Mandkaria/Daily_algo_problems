// Last updated: 10/18/2026, 9:57:16 AM
1class Solution {
2    private static final int MOD = 1_000_000_007;
3    private long[][] comb;
4    public int numOfWays(int[] nums) {
5        int n = nums.length;
6        comb = new long[n + 1][n + 1];
7        for (int i = 0; i <= n; i++) {
8            comb[i][0] = comb[i][i] = 1;
9            for (int j = 1; j < i; j++) {
10                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
11            }
12        }
13        long ans = solve(nums);
14        return (int) ((ans - 1 + MOD) % MOD);
15    }
16    private long solve(java.util.List<Integer> nums) {
17        int n = nums.size();
18        if (n <= 2) {
19            return 1;
20        }
21        int root = nums.get(0);
22        java.util.List<Integer> left = new java.util.ArrayList<>();
23        java.util.List<Integer> right = new java.util.ArrayList<>();
24        for (int i = 1; i < n; i++) {
25            if (nums.get(i) < root) {
26                left.add(nums.get(i));
27            } else {
28                right.add(nums.get(i));
29            }
30        }
31        long leftWays = solve(left);
32        long rightWays = solve(right);
33        long ways = comb[n - 1][left.size()];
34        ways = ways * leftWays % MOD;
35        ways = ways * rightWays % MOD;
36        return ways;
37    }
38    private long solve(int[] nums) {
39        java.util.List<Integer> list = new java.util.ArrayList<>();
40        for (int num : nums) {
41            list.add(num);
42        }
43        return solve(list);
44    }
45}