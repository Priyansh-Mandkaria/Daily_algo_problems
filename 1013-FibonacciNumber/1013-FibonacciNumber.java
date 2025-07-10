// Last updated: 7/10/2025, 8:56:32 AM
class Solution {
    public int fib(int n) {
        if(n <= 1){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }
}