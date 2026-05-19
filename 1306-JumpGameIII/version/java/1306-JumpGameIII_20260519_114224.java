// Last updated: 5/19/2026, 11:42:24 AM
1class Solution {
2    public boolean canReach(int[] arr, int start) {
3        if (start < 0 || start >= arr.length || arr[start] < 0) {
4            return false;
5        }
6        if (arr[start] == 0) {
7            return true;
8        }
9        int jumpDistance = arr[start];
10        arr[start] = -1; // Mark as visited
11        return canReach(arr, start + jumpDistance) || canReach(arr, start - jumpDistance);
12    }
13}