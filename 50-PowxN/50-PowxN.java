// Last updated: 7/10/2025, 8:59:18 AM
class Solution {
    public double myPow(double x, int n) {
        // return Math.pow(x,n);
        // double powy = 1;
        // if(n == 0){
        //     return powy;
        // }
        // if( n > 0){
        //     for( int i = 0 ; i < n ; i++){
        //         powy *= x; 
        //     }
        // }
        // else if ( n < 0){
        //     n = Math.abs(n);
        //     for( int i = 0 ; i < n ; i++){
        //         powy *= 1/x;
        //     }
        // }
        // return powy;
        if (n == 0) return 1; 
        if (n < 0) { 
            x = 1 / x;
            if (n == Integer.MIN_VALUE) {
                n = Integer.MAX_VALUE; 
                return x * myPow(x, n);
            } else {
                n = -n;
            }
        }
        double result = 1.0;
        while (n > 0) {
            if ((n % 2) == 1) { 
                result *= x;
            }
            x *= x;
            n /= 2; 
        }
        return result;
    }
}