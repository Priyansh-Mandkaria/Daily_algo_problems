// Last updated: 7/10/2025, 8:56:51 AM
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int l = Math.max(0, Math.min(rec1[2], rec2[2]) - Math.max(rec1[0], rec2[0]));
        int b = Math.max(0, Math.min(rec1[3], rec2[3]) - Math.max(rec1[1], rec2[1]));
        if ((l == 0 && b == 0) || (l >= 0 && b <= 0) || (l <= 0 && b >= 0))// negative area and concide condition..
        {
            return false;
        }
        else
        //if((l >= 0 && b >= 0) || (l <= 0 && b <= 0))// positive area of intersection
        {
            return true;
        }
    }
}