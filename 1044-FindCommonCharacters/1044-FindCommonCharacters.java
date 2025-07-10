// Last updated: 7/10/2025, 8:56:30 AM
import java.util.*;

class Solution {
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);
        for (String word : words) {
            int[] freq = new int[26];
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], freq[i]);
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < minFreq[i]; j++) {
                result.add(String.valueOf((char)(i + 'a')));
            }
        }        
        return result;
    }
}
