// Last updated: 7/10/2025, 8:50:26 AM
class Solution {
    public static int smallestNumber(int n, int t) {
        while (true) {
            int multi = digitProduct(n);
            if (multi % t == 0) {
                return n;
            }
            n++;
        }
    }
    private static int digitProduct(int num) {
        int product = 1;
        while (num > 0) {
            int digit = num % 10;
            product *= digit;
            num /= 10;
            if (product == 0) {
                return 0;
            }
        }
        return product;
    }
    
    
}