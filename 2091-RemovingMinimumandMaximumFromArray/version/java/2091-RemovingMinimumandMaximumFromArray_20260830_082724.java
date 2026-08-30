// Last updated: 8/30/2026, 8:27:24 AM
1class Solution {
2    public int minimumDeletions(int[] nums) {
3        int min = Integer.MAX_VALUE;
4        int max = Integer.MIN_VALUE;
5        int maxPos = 0;
6        int minPos = 0;
7        for(int i = 0; i < nums.length; i++){
8            if(nums[i] > max){
9                max = nums[i];
10                maxPos = i;
11            }
12            if(nums[i] < min){
13                min = nums[i];
14                minPos = i;
15            }
16        }
17        int front = Math.max(minPos, maxPos) + 1;
18        int back = nums.length - Math.min(minPos, maxPos);
19        int mid = Math.min(minPos + 1 + (nums.length - maxPos), maxPos + 1 + (nums.length - minPos));
20
21        int res = Math.min(front, back);
22        res = Math.min(res, mid);
23        return res;
24    }
25}