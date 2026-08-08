// Last updated: 8/8/2026, 10:37:17 PM
1class Solution {
2    public int[] decode(int[] encoded, int first) {
3        int n = encoded.length;
4        int arr[] = new int[n+1];
5        arr[0]=first;
6        for(int i=1;i<=n;i++)
7            {
8                arr[i]=arr[i-1]^encoded[i-1];
9            }
10        return arr;
11    }
12}