// Last updated: 5/16/2026, 9:43:05 AM
1class Solution {
2    public int findMin(int[] nums) {
3        int left = 0;
4        int right = nums.length - 1;
5        while (left < right) {
6            int mid = left + (right - left) / 2;
7            if (nums[mid] > nums[right]) {
8                left = mid + 1;
9            } else if (nums[mid] < nums[right]) {
10                right = mid;
11            } else {
12                right--;
13            }
14        }
15        return nums[left];
16    }
17}