// Last updated: 6/15/2026, 10:07:08 PM
1class Solution {
2    private boolean isSafePlace(int n, char[][] nQueens, int row, int col) {
3        for (int i = 0; i < n; i++) {
4            if (nQueens[i][col] == 'Q') {
5                return false;
6            }
7        }
8        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
9            if (nQueens[i][j] == 'Q') {
10                return false;
11            }
12        }
13        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
14            if (nQueens[i][j] == 'Q') {
15                return false;
16            }
17        }
18        return true;
19    }
20    private void solveNQueens(int n, List<List<String>> output, char[][] nQueens, int row) {
21        if (row == n) {
22            List<String> solution = new ArrayList<>();
23            for (char[] rowArray : nQueens) {
24                solution.add(new String(rowArray));
25            }
26            output.add(solution);
27            return;
28        }
29        for (int col = 0; col < n; col++) {
30            if (isSafePlace(n, nQueens, row, col)) {
31                nQueens[row][col] = 'Q';
32                solveNQueens(n, output, nQueens, row + 1);
33                nQueens[row][col] = '.';
34            }
35        }
36    }
37    public List<List<String>> solveNQueens(int n) {
38        List<List<String>> output = new ArrayList<>();
39        char[][] nQueens = new char[n][n];
40        for (int i = 0; i < n; i++) {
41            Arrays.fill(nQueens[i], '.');
42        }
43        solveNQueens(n, output, nQueens, 0); 
44        return output;
45    }
46}