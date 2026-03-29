// Last updated: 3/30/2026, 2:07:40 AM
1class Solution {
2    public void moveZeroes(int[] nums) {
3        int left = 0;
4        for(int i = 0 ; i < nums.length; i++){
5            if(nums[i] != 0){
6                int temp = nums[i];
7                nums[i] = nums[left];
8                nums[left] = temp;
9                left++;
10            }
11        }     
12    }
13}