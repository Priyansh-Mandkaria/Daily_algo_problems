// Last updated: 3/11/2026, 6:09:41 PM
1class Solution {
2    public int bitwiseComplement(int n) {
3        int mask =  n|1;
4        for(int i =0; i <= 4; i++){
5            mask |= mask >> (1 << i);
6        }
7        return n^mask;
8    }
9}