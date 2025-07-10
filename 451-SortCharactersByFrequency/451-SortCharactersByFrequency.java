// Last updated: 7/10/2025, 8:57:34 AM
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
            (a, b) -> frequencyMap.get(b) - frequencyMap.get(a)
        );
        maxHeap.addAll(frequencyMap.keySet());
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char current = maxHeap.poll();
            int frequency = frequencyMap.get(current);
            for (int i = 0; i < frequency; i++) {
                result.append(current);
            }
        }
        return result.toString(); 
    }
}