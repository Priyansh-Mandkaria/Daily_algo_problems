// Last updated: 1/13/2026, 9:28:51 AM
1class Solution {
2    private double helper(double line, int[][] squares) {
3        double aAbove = 0, aBelow = 0;
4        for (int i = 0; i < squares.length; i++) {
5            int x = squares[i][0], y = squares[i][1], l = squares[i][2];
6            double total = (double) l * l;
7            
8            if (line <= y) {
9                aAbove += total;
10            } else if (line >= y + l) {
11                aBelow += total;
12            } else {
13                // The line intersects the square.
14                double aboveHeight = (y + l) - line;
15                double belowHeight = line - y;
16                aAbove += l * aboveHeight;
17                aBelow += l * belowHeight;
18            }
19        }
20        return aAbove - aBelow;
21    }
22
23    public double separateSquares(int[][] squares) {
24        double lo = 0, hi = 2*1e9;
25
26        for (int i = 0; i < 60; i++) {
27            double mid = (lo + hi) / 2.0;
28            double diff = helper(mid, squares);
29            
30            if (diff > 0)
31                lo = mid;
32            else
33                hi = mid;
34        }
35        
36        return hi;
37    }
38}