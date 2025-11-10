// Last updated: 11/10/2025, 7:18:48 AM
class Solution {
    public int minOperations(int[] nums) {
    Deque<Integer> s = new ArrayDeque<>();
    int ops = 0;
    for (int x : nums) {
        while (!s.isEmpty() && s.peek() > x) { s.pop(); ops++; }
        if (x > 0 && (s.isEmpty() || s.peek() < x)) s.push(x);
    }
    while (!s.isEmpty()) if (s.pop() > 0) ops++;
    return ops;
    }
}