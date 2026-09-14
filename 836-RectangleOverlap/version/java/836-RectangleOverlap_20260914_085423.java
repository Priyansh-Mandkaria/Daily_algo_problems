// Last updated: 9/14/2026, 8:54:23 AM
1class Solution {
2    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
3        int l = Math.max(0, Math.min(rec1[2], rec2[2]) - Math.max(rec1[0], rec2[0]));
4        int b = Math.max(0, Math.min(rec1[3], rec2[3]) - Math.max(rec1[1], rec2[1]));
5        if ((l == 0 && b == 0) || (l >= 0 && b <= 0) || (l <= 0 && b >= 0))// negative area and concide condition..
6        {
7            return false;
8        }
9        else
10        //if((l >= 0 && b >= 0) || (l <= 0 && b <= 0))// positive area of intersection
11        {
12            return true;
13        }
14    }
15}