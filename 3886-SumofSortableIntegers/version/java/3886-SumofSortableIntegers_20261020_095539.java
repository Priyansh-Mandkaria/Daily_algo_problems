// Last updated: 10/20/2026, 9:55:39 AM
1class Solution {
2    public int sortableIntegers(int[] nums) {
3        int n = nums.length;
4        int[] s = nums.clone();
5        java.util.Arrays.sort(s);
6        int ans = 0;
7        
8        for (int k = 1; k <= n; k++) {
9            if (n % k != 0) {
10                continue;
11            }
12            boolean valid = true;
13            for (int start = 0; start < n; start += k) {
14                if (!checkRotation(nums, s, start, k)) {
15                    valid = false;
16                    break;
17                }
18            }
19            if (valid) {
20                ans += k;
21            }
22        }
23        return ans;
24    }
25    
26    private boolean checkRotation(int[] nums, int[] s, int start, int k) {
27        if (k == 1) {
28            return nums[start] == s[start];
29        }
30        
31        int[] lps = new int[k];
32        int len = 0;
33        int i = 1;
34        
35        while (i < k) {
36            if (s[start + i] == s[start + len]) {
37                len++;
38                lps[i] = len;
39                i++;
40            } else {
41                if (len != 0) {
42                    len = lps[len - 1];
43                } else {
44                    lps[i] = 0;
45                    i++;
46                }
47            }
48        }
49        
50        i = 0;
51        int j = 0;
52        
53        while (i < k * 2) {
54            if (s[start + j] == nums[start + (i % k)]) {
55                j++;
56                i++;
57            }
58            if (j == k) {
59                return true;
60            } else if (i < k * 2 && s[start + j] != nums[start + (i % k)]) {
61                if (j != 0) {
62                    j = lps[j - 1];
63                } else {
64                    i++;
65                }
66            }
67        }
68        
69        return false;
70    }
71}