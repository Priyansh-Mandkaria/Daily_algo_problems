// Last updated: 7/10/2025, 8:54:22 AM
class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] alphabet = new boolean[26];
        for (char c : sentence.toCharArray()) {
            alphabet[c - 'a'] = true;
        }
        for (boolean present : alphabet) {
            if (!present) {
                return false;
            }
        }
        return true;
    }
}