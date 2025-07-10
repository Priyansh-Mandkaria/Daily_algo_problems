// Last updated: 7/10/2025, 8:51:03 AM
class Solution {
    public String clearDigits(String s) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                if (res.length() > 0) {
                    res.deleteCharAt(res.length() - 1); 
                }
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}