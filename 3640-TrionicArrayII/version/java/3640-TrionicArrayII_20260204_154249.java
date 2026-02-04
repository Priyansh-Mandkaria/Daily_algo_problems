// Last updated: 2/4/2026, 3:42:49 PM
1class Solution {
2    public long maxSumTrionic(int[] nums) {
3        int state = 0;
4        long sum = 0;
5        long max =  Long.MIN_VALUE;
6        long contSum = 0;
7
8        for (int i = 1; i < nums.length; i++){
9            if (state == 0){
10                if (nums[i] > nums[i-1]){
11                    sum = sum + nums[i] + nums[i-1];
12                    state = 1;
13                }
14            }
15            else if (state == 1){
16                if (nums[i] > nums[i-1]){
17                    sum =Math.max(sum + nums[i], nums[i] + nums[i-1]);
18                }
19                else if (nums[i] == nums[i-1]){
20                    sum = 0;
21                    state = 0;
22                }
23                else {
24                    sum = sum + nums[i];
25                    state = 2;
26                }
27            }
28            else if (state == 2){
29                contSum = 0;
30                if (nums[i] < nums[i-1]){
31                    sum = sum + nums[i];
32                }
33                else if (nums[i] == nums[i-1]){
34                    sum = 0;
35                    state = 0;
36                }
37                else {
38                    sum = sum + nums[i];
39                    max = Math.max(max,sum);
40                    contSum = contSum + nums[i] + nums[i-1];
41                    state = 3;
42                }
43            }
44            else {
45                if (nums[i] > nums[i-1]){
46                    sum = sum + nums[i];
47                    contSum = Math.max(contSum + nums[i],nums[i] + nums[i-1]);
48                    max = Math.max(max,sum);
49                }
50                else if (nums[i] == nums[i-1]){
51                    sum = 0;
52                    state = 0;
53                }
54                else {
55                    sum = contSum + nums[i];
56                    state = 2;
57                }
58            }
59
60        }
61        return max;
62    }
63}