// Last updated: 8/5/2026, 9:13:25 AM
1class Solution {
2    public int numJewelsInStones(String jewels, String stones) {
3        int cnt = 0;
4        for(char c : stones.toCharArray()){
5            if(jewels.contains(String.valueOf(c)))cnt++;
6        }
7        return cnt;
8    }
9}