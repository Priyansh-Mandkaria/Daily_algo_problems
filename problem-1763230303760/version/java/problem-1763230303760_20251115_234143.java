// Last updated: 11/15/2025, 11:41:43 PM
class Solution {
    public boolean judgeCircle(String moves) {
        int cntR = 0,cntL = 0,cntU = 0,cntD = 0;
        for(int i = 0; i < moves.length(); i++){
            if(moves.charAt(i) == 'U'){
                cntU++;
            }
            else if (moves.charAt(i) == 'R'){
                cntR++;
            }
            else if (moves.charAt(i) == 'L'){
                cntL++;
            }
            else{
                cntD++;
            }
        }
        if(cntR == cntL && cntU == cntD) return true;
        return false;
    }
}