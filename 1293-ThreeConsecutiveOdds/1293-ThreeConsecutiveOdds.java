// Last updated: 7/10/2025, 8:56:02 AM
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        for(int i = 0 ; i < arr.length-2 ; i++){
            if(arr[i] % 2 != 0 && arr[i+1] % 2 != 0 && arr[i+2] % 2 != 0){
                return true;
            }
        }
        return false;
    }
}