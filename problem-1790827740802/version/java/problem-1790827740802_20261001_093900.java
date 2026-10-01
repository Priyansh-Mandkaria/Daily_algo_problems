// Last updated: 10/1/2026, 9:39:00 AM
1class Solution {
2    public boolean isValid(String s) {
3        Stack<Character> stack = new Stack<>();
4        for (char c : s.toCharArray()) {
5            if (c == '(' || c == '{' || c == '[') {
6                stack.push(c);
7            }
8            else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
9                stack.pop();
10            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
11                stack.pop();
12            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
13                stack.pop();
14            } else {
15                return false; 
16            }
17        }
18        return stack.isEmpty();
19    }
20}