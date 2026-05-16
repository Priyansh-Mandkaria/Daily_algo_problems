// Last updated: 5/16/2026, 9:42:17 AM
1class Solution {
2    public int findMin(int[] arr) {
3        int low = 0;
4        int n = arr.length;
5        int min = Integer.MAX_VALUE;
6        int high = n - 1;
7        while(low <= high){
8            int mid = low + (high - low)/2;
9            if(arr[low] <= arr[high]){
10                min = Math.min(min,arr[low]);
11                break;
12            }
13            if(arr[low] <= arr[mid]){
14                min = Math.min(min,arr[mid]);
15                low = mid + 1;
16            }
17            else{
18                min = Math.min(min,arr[mid]);
19                high = mid - 1;
20            }
21        }
22        return min;
23    }
24}