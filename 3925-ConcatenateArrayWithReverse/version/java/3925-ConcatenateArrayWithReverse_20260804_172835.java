// Last updated: 8/4/2026, 5:28:35 PM
1class Solution {
2    public int[] concatWithReverse(int[] nums) {
3        int[] arr = new int[2*nums.length];
4        for(int i = 0 ; i < nums.length; i++){
5            arr[i] = nums[i];
6        }
7        int index = nums.length;
8        for(int i = nums.length - 1 ; i >= 0; i--){
9            arr[index] = nums[i];
10            index++;
11        }
12        return arr;
13    }
14}