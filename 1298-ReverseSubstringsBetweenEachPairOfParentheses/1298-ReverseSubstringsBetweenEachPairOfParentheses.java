// Last updated: 7/10/2025, 8:56:00 AM
class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                List<Character> temp = new ArrayList<>();
                while (stack.peek() != '(') {
                    temp.add(stack.pop());
                }
                stack.pop(); // remove the '('
                for (char ch : temp) {
                    stack.push(ch);
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        return result.toString();
    }
}