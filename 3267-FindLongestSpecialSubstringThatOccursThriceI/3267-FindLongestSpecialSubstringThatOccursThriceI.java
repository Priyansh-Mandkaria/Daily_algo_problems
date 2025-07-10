// Last updated: 7/10/2025, 8:51:30 AM
class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        int maxLength = -1;
        for (int len = n; len >= 1; len--) { 
            Map<String, Integer> freqMap = new HashMap<>();
            for (int i = 0; i <= n - len; i++) {
                String substring = s.substring(i, i + len);
                if (isSpecial(substring)) {
                    freqMap.put(substring, freqMap.getOrDefault(substring, 0) + 1);
                }
            }
            for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
                if (entry.getValue() >= 3) {
                    return len; 
                }
            }
        }
        return maxLength; 
    }
    
    private static boolean isSpecial(String s) {
        char firstChar = s.charAt(0);
        for (char c : s.toCharArray()) {
            if (c != firstChar) {
                return false; 
            }
        }
        return true;
    }
}