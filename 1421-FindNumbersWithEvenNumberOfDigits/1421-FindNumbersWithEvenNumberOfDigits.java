// Last updated: 7/10/2025, 8:55:45 AM
import java.lang.Math;
class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int num : nums) {
            int digits = (int)(Math.log10(num))+1;
            if (digits % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}