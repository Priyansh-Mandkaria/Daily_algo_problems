// Last updated: 7/10/2025, 8:52:10 AM
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] C = new int[n];
        boolean[] seen = new boolean[n + 1];
        int commonCount = 0;
        for (int i = 0; i < n; i++) {
            if (seen[A[i]]) {
                commonCount++;
            }
            if (seen[B[i]]) {
                commonCount++;
            }
            if (A[i] == B[i]) {
                commonCount++;
            }
            seen[A[i]] = true;
            seen[B[i]] = true;
            C[i] = commonCount;
        }
        return C;
    }
}