// Last updated: 10/25/2025, 1:08:56 PM
class Solution {
    public int totalMoney(int n) {
        int weeks = n / 7;
        int days = n % 7;
        int sum = 0;
        for (int i = 0; i < weeks; i++) {
            int start = i + 1; 
            sum += 7 * start + 21; 
        }
        for (int i = 0; i < days; i++) {
            sum += weeks + 1 + i;
        }
        return sum;
    }
}