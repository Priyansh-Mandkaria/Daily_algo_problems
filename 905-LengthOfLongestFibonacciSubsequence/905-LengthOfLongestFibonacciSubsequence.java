// Last updated: 7/10/2025, 8:56:46 AM
class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        if(arr.length <= 2){
            return 0;
        }
        int n = arr.length;
        Map<Integer,Integer> index = new HashMap<>();
        for(int i = 0; i < n; i++){
            index.put(arr[i],i);
        }
        int max = 0;
        for(int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++) {
                int prev = arr[j];
                int prevv = arr[i];
                int len = 2;
                while (index.containsKey(prev + prevv)) {
                    len++;
                    max = Math.max(max, len);
                    int temp = prev;
                    prev = prev + prevv;
                    prevv = temp;
                }
            }
        }
         return max > 2 ? max : 0;
    }
}