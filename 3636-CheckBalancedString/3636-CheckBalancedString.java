// Last updated: 7/10/2025, 8:50:17 AM
class Solution {
    public boolean isBalanced(String num) { 
        char[] arr = num.toCharArray();
        int even = 0;
        int odd = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(i % 2 == 0){
                even += Character.getNumericValue(arr[i]);
            }
            else{
                odd += Character.getNumericValue(arr[i]);
            }
        }
        if(even == odd){
            return true;
        }
        return false;
    }
}