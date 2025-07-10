// Last updated: 7/10/2025, 8:54:32 AM
class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];
        int balls = 0, operations = 0;
        for (int i = 0; i < n; i++) {
            answer[i] = operations;
            if (boxes.charAt(i) == '1') {
                balls++;
            }
            operations += balls;
        }
        balls = 0;
        operations = 0;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] += operations;
            if (boxes.charAt(i) == '1') {
                balls++;
            }
            operations += balls;
        }
        return answer;
    }
}