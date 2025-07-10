// Last updated: 7/10/2025, 8:57:01 AM
class Solution {
    public int numRabbits(int[] answers) {
        int count = 0;
        int[] freq = new int[1001];
        for (int a : answers)
            freq[a]++;
        for (int i = 1; i < 1001; i++) {
            if (freq[i] > 0) {
                count += ((freq[i] + i) / (i + 1)) * (i + 1);
            }
        }
        return count + freq[0];
    }
}