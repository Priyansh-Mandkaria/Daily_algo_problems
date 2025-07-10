// Last updated: 7/10/2025, 8:57:12 AM
class Solution {
    public int calPoints(String[] operations) {
        List<Integer> scores = new ArrayList<>();
        for (String op : operations) {
            if (op.equals("+")) {
                int newScore = scores.get(scores.size() - 1) + scores.get(scores.size() - 1 - 1);
                scores.add(newScore);
            } else if (op.equals("D")) {
                int newScore = 2 * scores.get(scores.size() - 1);
                scores.add(newScore);
            } else if (op.equals("C")) {
                scores.remove(scores.size() - 1);
            } else {
                scores.add(Integer.valueOf(op));
            }
        }
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }       
        return sum;
    }
}