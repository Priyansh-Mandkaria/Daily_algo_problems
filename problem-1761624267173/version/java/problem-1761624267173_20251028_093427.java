// Last updated: 10/28/2025, 9:34:27 AM
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