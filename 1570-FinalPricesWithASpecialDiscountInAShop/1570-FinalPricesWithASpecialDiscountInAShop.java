// Last updated: 7/10/2025, 8:55:13 AM
class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int index = stack.pop();
                result[index] = prices[index] - prices[i];
            }
            stack.push(i);
            result[i] = prices[i]; 
        }
        return result;
    }
}