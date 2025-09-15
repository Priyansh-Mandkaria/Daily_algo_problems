// Last updated: 9/15/2025, 7:55:32 AM
class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] broken = new boolean[26];
        for (char c : brokenLetters.toCharArray()) {
            broken[c - 'a'] = true;
        }

        int count = 0;
        boolean ok = true;

        for (int i = 0; i <= text.length(); i++) {
            if (i < text.length() && text.charAt(i) != ' ') {
                if (broken[text.charAt(i) - 'a']) {
                    ok = false;
                }
            } else {
                if (ok) count++;
                ok = true;
            }
        }
        return count;
    }
}