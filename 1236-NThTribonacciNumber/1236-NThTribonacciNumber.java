// Last updated: 7/10/2025, 8:56:05 AM
class Solution {
    public int tribonacci(int n) {
        if ( n == 0 )
        {
            return n;
        }
        if ( n == 1 || n == 2){
            return 1;
        }
        // int b = tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);
        // return b;
        // this above is correct but recursive approch 
        // now we are going to provide itreative approch so we can do in time limit
        int a = 0 , b = 1 , c = 1 ;
        for(int i = 3; i <= n ; i++){
            int temp = a + b + c;
            a = b;
            b = c;
            c = temp;
        }
        return c;



    }

}