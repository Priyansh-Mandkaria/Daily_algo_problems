// Last updated: 6/18/2026, 10:45:23 AM
/*
 * Easy question , min angle return karna tha.
 * angle ka formula hai bas aur kuch nahi
*/

1class Solution {
2    public double angleClock(int hour, int min) {
3        // iska seedha formula hota hai , ya tum khud bhi derive kar sakte ho .
4        // angle of minute hand ==
5        // angle(min) = 6*min; har min itna angle kisikta hai
6        // angle of hour hand ==
7        // angle(hour) = 30*hour + 0.5*min; hai min itna angle kiskhat hai , 
8        // angle between them = |angle(hour) - angle(min)|
9        // second angle = 360 - angle between them.
10        // in this question they asked me about second one ??
11        // abee answer se dekh le yaar confuse mat ho.
12        return Math.min(360 - Math.abs(30*hour + 0.5*min - 6*min) , Math.abs(30*hour + 0.5*min - 6*min));
13        }
14}