// Last updated: 6/13/2026, 1:33:33 PM
1class Solution {
2    public String mapWordWeights(String[] words, int[] weights) {
3        StringBuilder ans = new StringBuilder();
4        for (String word : words) {
5            long sum = 0;
6            for (char ch : word.toCharArray()) {
7                sum += weights[ch - 'a'];
8            }
9            int remainder = (int)(sum % 26);
10            ans.append((char)('z' - remainder));
11        }
12        return ans.toString();
13    }
14}