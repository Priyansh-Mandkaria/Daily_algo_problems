// Last updated: 7/25/2026, 9:24:01 AM
class Solution {
    public int addDigits(int num) {
        if(num == 0) return 0;
        return 1 + (num - 1) % 9;
    }
}