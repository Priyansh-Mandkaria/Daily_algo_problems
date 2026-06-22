// Last updated: 6/22/2026, 1:37:48 PM
class Solution {
    public int countValidSelections(int[] nums) {
        int prefix=0, cnt=0, sum=0;
        for(int x : nums) sum+=x;
        for(int x : nums){
            prefix+=x;
            if (x==0){
                final int move=Math.max(2-Math.abs(2*prefix-sum), 0);
                cnt+=move;
            }
        }
        return cnt;
    }
}