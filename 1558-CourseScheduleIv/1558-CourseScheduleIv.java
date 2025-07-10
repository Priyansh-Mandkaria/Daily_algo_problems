// Last updated: 7/10/2025, 8:55:15 AM
class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] isPre = new boolean[numCourses][numCourses];
        for (int[] prereq : prerequisites) {
            isPre[prereq[0]][prereq[1]] = true;
        }
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    isPre[i][j] |= isPre[i][k] && isPre[k][j];
                }
            }
        }
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(isPre[query[0]][query[1]]);
        }
        return result;
    }
}