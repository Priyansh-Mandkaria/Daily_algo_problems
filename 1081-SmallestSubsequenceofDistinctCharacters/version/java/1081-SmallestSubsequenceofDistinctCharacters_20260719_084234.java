// Last updated: 7/19/2026, 8:42:34 AM
1class Solution {
2    public String smallestSubsequence(String s) {
3        int[] freq = new int[26];
4        for (char c : s.toCharArray()) {
5            freq[c - 'a']++;
6        }
7        boolean[] inStack = new boolean[26];
8        StringBuilder stack = new StringBuilder();
9        for (char c : s.toCharArray()) {
10            freq[c - 'a']--;
11            if (inStack[c - 'a']) {
12                continue;
13            }
14            while (stack.length() > 0 &&
15                   stack.charAt(stack.length() - 1) > c &&
16                   freq[stack.charAt(stack.length() - 1) - 'a'] > 0) {
17                inStack[stack.charAt(stack.length() - 1) - 'a'] = false;
18                stack.deleteCharAt(stack.length() - 1);
19            }
20            stack.append(c);
21            inStack[c - 'a'] = true;
22        }
23        return stack.toString();
24    }
25}