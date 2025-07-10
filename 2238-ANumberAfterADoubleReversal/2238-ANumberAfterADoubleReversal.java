// Last updated: 7/10/2025, 8:53:37 AM
class Solution {
    public boolean isSameAfterReversals(int num) {
        int reverse1;
        int reverse2;
        reverse1 = reverse(num);
        reverse2 = reverse(reverse1);
        if(reverse2 == num){
            return true;
        }
        return false;
    }
    public static int reverse(int a){
        int n = 0;
        int temp;
        while(a != 0){
            temp = a % 10;
            n = n * 10 + temp;
            a = a/10;
        } 
        return n;
    }
}