// Last updated: 9/13/2026, 8:28:35 AM
1class Solution {
2    protected int shiftAndCount(int xShift, int yShift, int[][] M, int[][] R) {
3        int leftShiftCount = 0, rightShiftCount = 0;
4        int rRow = 0;
5        for (int mRow = yShift; mRow < M.length; ++mRow) {
6            int rCol = 0;
7            for (int mCol = xShift; mCol < M.length; ++mCol) {
8                if (M[mRow][mCol] == 1 && M[mRow][mCol] == R[rRow][rCol])
9                    leftShiftCount += 1;
10                if (M[mRow][rCol] == 1 && M[mRow][rCol] == R[rRow][mCol])
11                    rightShiftCount += 1;
12                rCol += 1;
13            }
14            rRow += 1;
15        }
16        return Math.max(leftShiftCount, rightShiftCount);
17    }
18    public int largestOverlap(int[][] A, int[][] B) {
19        int maxOverlaps = 0;
20        for (int yShift = 0; yShift < A.length; ++yShift)
21            for (int xShift = 0; xShift < A.length; ++xShift) {
22                maxOverlaps = Math.max(maxOverlaps, shiftAndCount(xShift, yShift, A, B));
23                maxOverlaps = Math.max(maxOverlaps, shiftAndCount(xShift, yShift, B, A));
24            }
25        return maxOverlaps;
26    }
27}