// Last updated: 8/11/2026, 10:16:14 AM
1class Solution {
2    public int missingInteger(int[] nums) {
3        int n = nums.length;
4        int sequentialSum = nums[0];
5        for(int i = 1; i < n; i++){
6            if(nums[i] == nums[i - 1] + 1)
7                sequentialSum += nums[i];
8            else
9                break;
10        }
11        while(true){
12            boolean found = false;
13            for(int num : nums){
14                if(num == sequentialSum){
15                    found = true;
16                    break;
17                }
18            }
19            if(!found)
20                return sequentialSum;
21
22            sequentialSum++;
23        }
24    }
25}