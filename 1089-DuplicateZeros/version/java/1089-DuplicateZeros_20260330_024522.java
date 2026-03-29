// Last updated: 3/30/2026, 2:45:22 AM
1class Solution {
2    public void duplicateZeros(int[] arr) {
3        int[] res = new int[arr.length];
4        int j = 0;
5        for(int i = 0; i < arr.length && j < arr.length; i++){
6            if(arr[i] == 0){
7                res[j] = 0;
8                if(j + 1 < arr.length){
9                    res[j + 1] = 0;
10                }
11                j += 2;
12            } else {
13                res[j] = arr[i];
14                j++;
15            }
16        }
17        for(int i = 0 ; i < arr.length; i++){
18            arr[i] = res[i];
19        }
20    }
21}