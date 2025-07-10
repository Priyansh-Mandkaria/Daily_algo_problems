// Last updated: 7/10/2025, 8:58:31 AM
class Solution {
    public int majorityElement(int[] arr) {
        // naive approch or brute approch
        // Time limit exceed O(n^2);
        // for(int i = 0 ; i < arr.length; i++){
        //     int cnt = 0;
        //     for(int j = 0 ; j < arr.length; j++ ){
        //         if(arr[i] == arr[j]){
        //             cnt++;
        //         }
        //         if( cnt > arr.length/2) return arr[i];
        //     }
        // }
        // return -1;
        // Using Hashmap 
        int n = arr.length;
        HashMap<Integer,Integer> mpp = new HashMap<>();
        for(int i = 0 ; i < n; i++){
            int value = mpp.getOrDefault(arr[i],0);
            mpp.put(arr[i],value+1);
        }
        for(Map.Entry<Integer,Integer> it : mpp.entrySet()){
            if(it.getValue() > n/2){
                return it.getKey();
            }
        }
        return -1;
    }
}