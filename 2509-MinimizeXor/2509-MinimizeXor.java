// Last updated: 7/10/2025, 8:52:55 AM
class Solution {
    public int minimizeXor(int num1, int num2) {
        int setBitsNum2 = Integer.bitCount(num2);
        int setBitsNum1 = Integer.bitCount(num1);
        int result = num1;
        if (setBitsNum1 < setBitsNum2) {
            int bitsToAdd = setBitsNum2 - setBitsNum1;
            for (int i = 0; i < 32 && bitsToAdd > 0; i++) {
                if ((result & (1 << i)) == 0) { 
                    result |= (1 << i); 
                    bitsToAdd--;
                }
            }
        } else if (setBitsNum1 > setBitsNum2) {
            int bitsToRemove = setBitsNum1 - setBitsNum2;
            for (int i = 0; i < 32 && bitsToRemove > 0; i++) {
                if ((result & (1 << i)) != 0) {
                    result &= ~(1 << i); 
                    bitsToRemove--;
                }
            }
        }
        return result;
    }
}