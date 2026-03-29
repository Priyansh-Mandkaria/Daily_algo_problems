// Last updated: 3/30/2026, 3:37:08 AM
1class Solution {
2    public int majorityElement(int[] arr) {
3        // naive approch or brute approch
4        // Time limit exceed O(n^2);
5        // for(int i = 0 ; i < arr.length; i++){
6        //     int cnt = 0;
7        //     for(int j = 0 ; j < arr.length; j++ ){
8        //         if(arr[i] == arr[j]){
9        //             cnt++;
10        //         }
11        //         if( cnt > arr.length/2) return arr[i];
12        //     }
13        // }
14        // return -1;
15        // Using Hashmap 
16        int n = arr.length;
17        HashMap<Integer,Integer> mpp = new HashMap<>();
18        for(int i = 0 ; i < n; i++){
19            int value = mpp.getOrDefault(arr[i],0)+1;
20            mpp.put(arr[i],value);
21        }
22        for(Map.Entry<Integer,Integer> it : mpp.entrySet()){
23            if(it.getValue() > n/2){
24                return it.getKey();
25            }
26        }
27        return -1;
28    }
29}