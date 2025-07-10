// Last updated: 7/10/2025, 8:58:06 AM
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 0 || n < 0){
            return false;
        }
        while(n > 1){
            if(n % 2 != 0){
                return false;
            }
            n = n/2;
        }
        return true;
    }
}