// Last updated: 6/15/2026, 9:51:54 PM
1class Solution {
2    public int threeSumClosest(int[] nums, int target) {
3        Arrays.sort(nums);
4        int n = nums.length;
5        int result = nums[0]+nums[1]+nums[2];
6        for(int i = 0; i < n-2; i++){
7            int left = i + 1, right= n-1;
8            while(left < right){
9                int sum  = nums[i] + nums[left] + nums[right];
10                if(Math.abs(target-sum) < Math.abs(target-result)){
11                    result = sum;
12                }
13                if(sum == target) return target;
14                else if(sum < target) left++;
15                else right--;
16            }
17        }
18        return result;
19    }
20}