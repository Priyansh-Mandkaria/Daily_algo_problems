// Last updated: 7/10/2025, 8:55:46 AM
class Solution {
    public int subtractProductAndSum(int n) {
        n = Math.abs(n);
        int product = 1;
        int sum = 0;
        while (n > 0) {
            int digit = n % 10; 
            product *= digit;
            sum += digit;
            n /= 10; 
        }
        return product - sum;
    }

}

