// Last updated: 7/10/2025, 8:51:29 AM
class Solution {
    public int minimumPushes(String word) {
        int[] frequency = new int[26];
        for (char c : word.toCharArray()) {
            frequency[c - 'a']++;
        }
        List<Integer> freqList = new ArrayList<>();
        for (int freq : frequency) {
            if (freq > 0) {
                freqList.add(freq);
            }
        }
        Collections.sort(freqList, Collections.reverseOrder());
        int keyPresses = 0;
        int presses = 1;
        int count = 0;
        for (int freq : freqList) {
            keyPresses += freq * presses;
            count++;
            if (count == 8) {
                presses++;
                count = 0;
            }
        }
        return keyPresses;
    }
}