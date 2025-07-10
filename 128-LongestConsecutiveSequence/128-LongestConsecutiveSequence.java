// Last updated: 7/10/2025, 8:58:45 AM
class Solution {
    public int longestConsecutive(int[] arr) {
        // better approach then brute force in 1st try. not bad //
        if(arr.length == 0) return 0;
        if(arr.length == 1) return 1; 
        Arrays.sort(arr);
        int max = 1;
        int maxsq = 1;
        for(int i = 1 ; i < arr.length; i++){
            if( arr[i] == arr[i-1] + 1){
                max++;
            }
            else if (arr[i] == arr[i-1]){
                continue;
            }
            else{
                max = 1;
            }
            maxsq = Math.max(maxsq,max);
        }
        return maxsq;
    }
}