// Last updated: 7/10/2025, 9:00:01 AM
class Solution {
    public boolean isPalindrome(int x) {
        int temp = x;
        int reversed = 0;
        if( x < 0){
            return false;
        }
        while( x != 0){
            int digit = x % 10;
            x /= 10;
            reversed = reversed * 10 + digit;
        }
        if( temp == reversed){
            return true;
        }
        return false;
    }
}