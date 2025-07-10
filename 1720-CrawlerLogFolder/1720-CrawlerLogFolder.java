// Last updated: 7/10/2025, 8:54:55 AM
class Solution {
    public int minOperations(String[] logs) {
        int count = 0;
        for (String log : logs) {
            if (log.equals("../")) {
                if (count > 0) {
                    count--;
                }
            } else if (!log.equals("./")) {
                count++;
            }
        }
        return count;
    }
}