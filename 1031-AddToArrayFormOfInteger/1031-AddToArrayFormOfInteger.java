// Last updated: 7/10/2025, 8:56:31 AM
import java.util.*;

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int n = num.length;
        int carry = k;
        
        // Traverse num from right to left and add carry
        for (int i = n - 1; i >= 0; i--) {
            int sum = num[i] + carry;
            result.add(0, sum % 10); // Add the least significant digit to the front of result
            carry = sum / 10; // Update carry
        }
        
        // Add remaining carry digits
        while (carry > 0) {
            result.add(0, carry % 10); // Add each digit to the front of result
            carry /= 10;
        }
        
        // Remove leading zeros
        while (result.size() > 1 && result.get(0) == 0) {
            result.remove(0);
        }
        
        return result;
    }
}
