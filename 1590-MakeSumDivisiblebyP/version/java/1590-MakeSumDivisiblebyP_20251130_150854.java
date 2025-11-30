// Last updated: 11/30/2025, 3:08:54 PM
1class Solution {
2    public int minSubarray(int[] nums, int p) {
3        long sum = 0;
4        for (int num : nums) {
5            sum += num;
6        }
7        if (sum < p)
8            return -1;
9        long target = sum % p;
10        if (target == 0)
11            return 0;
12        HashMap<Integer, Integer> HM = new HashMap<>();
13        HM.put(0, -1);
14        sum = 0;
15        int res = Integer.MAX_VALUE;
16        for (int i = 0; i < nums.length; i++) {
17            if (nums[i] % p == target)
18                return 1;
19            sum += nums[i];
20            int a = (int) (sum % p);
21            int b = (int) ((sum - target) % p);
22            if (HM.containsKey(b))
23                res = Math.min(i - HM.get(b), res);
24            HM.put(a, i);
25        }
26        if (res >= nums.length)
27            return -1;
28        return res;
29    }
30}