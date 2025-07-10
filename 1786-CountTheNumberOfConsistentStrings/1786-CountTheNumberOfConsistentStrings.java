// Last updated: 7/10/2025, 8:54:49 AM
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
      Set<Character> allowedSet = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            allowedSet.add(c);
        }
        int consistentCount = 0;
        for (String word : words) {
            boolean isConsistent = true;
            for (char c : word.toCharArray()) {
                if (!allowedSet.contains(c)) {
                    isConsistent = false;
                    break;
                }
            }
            if (isConsistent) {
                consistentCount++;
            }
        }
        return consistentCount;  
    }
}