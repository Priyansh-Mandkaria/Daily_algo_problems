// Last updated: 7/20/2025, 2:39:33 PM
class Solution {
    public boolean checkDivisibility(int n) {
        int cur = n, t = 0;
        long mul =1;
        while(cur > 0){
            int x = cur % 10;
            if(x == 0) mul = 0;
            if(mul != 0 ) mul*= x;
            t += x;
            cur/=10;
        }
        return n %(mul+t) == 0;
    }
}