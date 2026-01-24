// Last updated: 1/24/2026, 12:32:27 PM
1class Solution {
2    public int minPairSum(int[] nums) {
3        int n = nums.length;
4        if (n <= 200) {
5            Arrays.sort(nums);
6            int res = 0;
7            for (int i = 0; i < (n >> 1); i++)
8                res = Math.max(res, nums[n - 1 - i] + nums[i]);
9            return res;
10        }
11
12        int max = 0;
13        for (int num : nums)
14            max = Math.max(max, num);
15
16        int[] freq = new int[max + 1];
17        for (int num : nums)
18            freq[num]++;
19
20        int i = 0, j = max;
21        while (i <= max && freq[i] == 0) i++;
22        while (j >= 0 && freq[j] == 0) j--;
23
24        int res = 0;
25        for (int k = nums.length / 2; k > 0; k--) {
26            res = Math.max(res, i + j);
27            freq[i]--;
28            freq[j]--;
29
30            if (freq[i] == 0)
31                while (i <= max && freq[i] == 0) i++;
32
33            if (freq[j] == 0)
34                while (j >= 0 && freq[j] == 0) j--;
35        }
36        return res;
37    }
38}
39