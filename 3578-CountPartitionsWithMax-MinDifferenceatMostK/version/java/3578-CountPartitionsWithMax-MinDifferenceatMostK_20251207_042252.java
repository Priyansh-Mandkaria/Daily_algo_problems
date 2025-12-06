// Last updated: 12/7/2025, 4:22:52 AM
1class Solution {
2    public int countPartitions(int[] nums, int k) {
3        int MOD = (int) 1e9 + 7, n = nums.length, left = 0;
4        int[] dp = new int[n + 1], prefix = new int[n + 2]; 
5        
6        dp[0] = 1; prefix[1] = 1; 
7        
8        Deque<Integer> min = new ArrayDeque<>(), max = new ArrayDeque<>();
9                
10        for (int i = 0; i < n; i++) {
11            while (!max.isEmpty() && nums[max.peekLast()] <= nums[i]) {
12                max.pollLast();
13            }
14            max.addLast(i);
15            
16            while (!min.isEmpty() && nums[min.peekLast()] >= nums[i]) {
17                min.pollLast();
18            }
19            min.addLast(i);
20            
21            while (nums[max.peekFirst()] - nums[min.peekFirst()] > k) {
22                if (max.peekFirst() == left) max.pollFirst();
23                if (min.peekFirst() == left) min.pollFirst();
24                
25                left++;
26            }
27            
28            dp[i + 1] = (prefix[i + 1] - prefix[left] + MOD) % MOD;
29            
30            prefix[i + 2] = (prefix[i + 1] + dp[i + 1]) % MOD;
31        }
32        
33        return dp[n];
34    }
35}