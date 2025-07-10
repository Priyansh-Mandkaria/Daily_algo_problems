// Last updated: 7/10/2025, 8:55:05 AM
class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
       Deque<int[]> deque = new LinkedList<>();
        int maxValue = Integer.MIN_VALUE;
        for (int[] point : points) {
            int x = point[0], y = point[1];
            while (!deque.isEmpty() && x - deque.getFirst()[1] > k) {
                deque.pollFirst();
            }
            if (!deque.isEmpty()) {
                maxValue = Math.max(maxValue, y + x + deque.getFirst()[0]);
            }
            while (!deque.isEmpty() && deque.getLast()[0] <= y - x) {
                deque.pollLast();
            }
            deque.offerLast(new int[] { y - x, x });
        }
        return maxValue; 
    }
}