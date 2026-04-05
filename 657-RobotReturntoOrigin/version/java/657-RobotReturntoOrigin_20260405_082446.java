// Last updated: 4/5/2026, 8:24:46 AM
1class Solution {
2    public boolean judgeCircle(String moves) {
3        int cntR = 0,cntL = 0,cntU = 0,cntD = 0;
4        for(int i = 0; i < moves.length(); i++){
5            if(moves.charAt(i) == 'U'){
6                cntU++;
7            }
8            else if (moves.charAt(i) == 'R'){
9                cntR++;
10            }
11            else if (moves.charAt(i) == 'L'){
12                cntL++;
13            }
14            else{
15                cntD++;
16            }
17        }
18        if(cntR == cntL && cntU == cntD) return true;
19        return false;
20    }
21}