// Last updated: 7/10/2025, 8:53:39 AM
class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0) return false;
        int balance = 0;
        int free = 0; 
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '0') {
                free++;
            } else if (s.charAt(i) == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance + free < 0) return false; 
        }
        balance = 0;
        free = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0') {
                free++;
            } else if (s.charAt(i) == ')') {
                balance++;
            } else {
                balance--;
            }
            if (balance + free < 0) return false; 
        }
        return true;
    }
}