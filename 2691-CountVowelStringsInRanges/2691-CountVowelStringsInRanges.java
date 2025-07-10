// Last updated: 7/10/2025, 8:52:28 AM
class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefix = new int[words.length];
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1))) {
                count++;
            }
            prefix[i] = count;
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            if (l == 0) {
                res[i] = prefix[r];
            } else {
                res[i] = prefix[r] - prefix[l - 1];
            }
        }
        return res;
    }
    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}