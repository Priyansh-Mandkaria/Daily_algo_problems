// Last updated: 12/22/2025, 5:32:44 PM
1class Solution {
2    public boolean rotateString(String s, String goal) {
3        //we dont have direct method like c++ have in stl to rotate string
4        // rotate(s.begin(),s.begin()+1,s.end());
5        // so what we are goona do in the java my dear in brute force is 
6        // break into substring and then concate
7        // Strings must be same length to be rotations of each other
8        if (s.length() != goal.length()) {
9            return false;
10        }
11        for (int i = 0; i < s.length(); i++) {
12            String rotated = s.substring(i) + s.substring(0, i);
13            if (rotated.equals(goal)) {
14                return true;  
15            }
16        }
17        return false;
18    }
19}