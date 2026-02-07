// Last updated: 2/8/2026, 12:46:41 AM
1class Solution {
2    public int minRemoval(int[] arr, int k) {
3        Arrays.sort(arr);
4        int cnt = 0;
5        int max = 0;
6        for(int i = 0; i < arr.length; i++){
7            while(cnt <= i && (long)arr[i] > (long)arr[cnt]*k) cnt++;
8            max = Math.max(max,i-cnt+1);
9        }
10        int j = arr.length - max;
11        return j;
12    }
13}