// Last updated: 3/30/2026, 2:43:46 AM
1class Solution {
2    public void duplicateZeros(int[] arr) {
3        int[] res = new int[arr.length + 1000000];
4        int j = 0;
5        for(int i = 0 ; i < arr.length; i++){
6            if(arr[i] == 0){
7                res[j] = arr[i];
8                res[j+1] = arr[i];
9                j = j + 2;
10            }
11            else{
12                res[j] = arr[i];
13                j++;
14            }
15        }
16        for(int i = 0 ; i < arr.length; i++){
17            arr[i] = res[i];
18        }
19    }
20}