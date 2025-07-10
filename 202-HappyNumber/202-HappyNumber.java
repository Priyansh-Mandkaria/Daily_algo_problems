// Last updated: 7/10/2025, 8:58:19 AM
public class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        
        do {
            slow = sumOfSquares(slow);      // move slow one step
            fast = sumOfSquares(sumOfSquares(fast));  // move fast two steps
        } while (slow != fast);  // until they meet
        
        return slow == 1;  // if they meet at 1, n is a happy number
    }
    
    private int sumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }
}
