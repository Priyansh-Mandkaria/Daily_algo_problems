// Last updated: 7/10/2025, 8:53:21 AM
class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
    int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) maxHeap.add((char) ('a' + i));
        }
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char current = maxHeap.poll();
            int count = Math.min(freq[current - 'a'], repeatLimit);
            for (int i = 0; i < count; i++) result.append(current);
            freq[current - 'a'] -= count;
            if (freq[current - 'a'] > 0) {
                if (maxHeap.isEmpty()) break;
                char next = maxHeap.poll();
                result.append(next);
                freq[next - 'a']--;
                if (freq[next - 'a'] > 0) maxHeap.add(next);
                maxHeap.add(current);
            }
        }
        return result.toString();
    }
}