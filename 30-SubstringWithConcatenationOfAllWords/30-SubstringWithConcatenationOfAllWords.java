// Last updated: 7/10/2025, 8:59:39 AM
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        int wordLength = words[0].length();
        int wordCount = words.length;
        int substringLength = wordLength * wordCount;
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < wordLength; i++) {
            int left = i, right = i, count = 0;
            Map<String, Integer> seenWords = new HashMap<>();

            while (right + wordLength <= s.length()) {
                String word = s.substring(right, right + wordLength);
                right += wordLength;

                if (wordMap.containsKey(word)) {
                    seenWords.put(word, seenWords.getOrDefault(word, 0) + 1);
                    count++;

                    while (seenWords.get(word) > wordMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        seenWords.put(leftWord, seenWords.get(leftWord) - 1);
                        count--;
                        left += wordLength;
                    }

                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    seenWords.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        return result;
    }
}