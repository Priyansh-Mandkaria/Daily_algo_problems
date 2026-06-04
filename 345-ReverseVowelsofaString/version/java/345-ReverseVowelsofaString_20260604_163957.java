// Last updated: 6/4/2026, 4:39:57 PM
1class Solution {
2    public String reverseVowels(String s) {
3        char[] word = s.toCharArray();
4        int start = 0;
5        int end = s.length() - 1;
6        String vowels = "aeiouAEIOU";
7        while (start < end) {
8            while (start < end && vowels.indexOf(word[start]) == -1) {
9                start++;
10            }
11            while (start < end && vowels.indexOf(word[end]) == -1) {
12                end--;
13            }
14            char temp = word[start];
15            word[start] = word[end];
16            word[end] = temp;
17            start++;
18            end--;
19        }
20        String answer = new String(word);
21        return answer;
22    }
23}