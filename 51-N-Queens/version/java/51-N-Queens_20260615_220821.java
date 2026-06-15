// Last updated: 6/15/2026, 10:08:21 PM
1class Solution {
2    int count = 0;
3    public int totalNQueens(int n) {
4        char[][] board = new char[n][n];
5        for(int i = 0; i < n; i++){
6            for(int j = 0; j < n; j++){
7                board[i][j] = '.';
8            }
9        }
10        nqueen(board, 0, n);
11        return count;
12    }
13    private void nqueen(char[][] board, int row, int n){
14        if(row == n){
15            count++;
16            return;
17        }
18        for(int col = 0; col < n; col++){
19            if(isSafe(board,row,col,n)){
20                board[row][col] = 'Q';
21                nqueen(board, row+1, n);
22                board[row][col] = '.';
23            }
24        }
25    }
26    private boolean isSafe(char[][] board, int row ,int col, int n){
27        int i,j;
28        for( i = 0; i < n; i++){
29           if(board[i][col] == 'Q') return false;
30        }
31         i = row;
32         j = col;
33        while(i >= 0 && j < n){
34            if(board[i][j] == 'Q') return false;
35            i--;
36            j++;
37        }
38        i = row;
39        j = col;
40        while(i >= 0 && j >= 0){
41            if(board[i][j] == 'Q') return false;
42            i--;
43            j--; 
44    }
45    return true;
46    }
47}