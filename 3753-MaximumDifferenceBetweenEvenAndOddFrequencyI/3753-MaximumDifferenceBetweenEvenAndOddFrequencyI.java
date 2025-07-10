// Last updated: 7/10/2025, 8:49:46 AM
class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        List<Integer> oddFrequencies = new ArrayList<>();
        List<Integer> evenFrequencies = new ArrayList<>();
        for (int f : freq) {
            if (f > 0) { 
                if (f % 2 == 0) {
                    evenFrequencies.add(f);
                } else {
                    oddFrequencies.add(f);
                }
            }
        }
        int maxOdd = Collections.max(oddFrequencies);
        int minEven = Collections.min(evenFrequencies); 
        return maxOdd - minEven;
    }
}