// Last updated: 12/25/2025, 10:43:29 PM
1class Solution {
2    public int myAtoi(String s) {
3        if (s == null || s.length() == 0) {
4            return 0;
5        }
6        
7        // Constants for 32-bit signed integer range
8        final int INT_MAX = Integer.MAX_VALUE;
9        final int INT_MIN = Integer.MIN_VALUE;
10        
11        int i = 0;
12        int n = s.length();
13        
14        // Step 1: Skip leading whitespace
15        while (i < n && s.charAt(i) == ' ') {
16            i++;
17        }
18        
19        // Check if we've reached the end
20        if (i == n) {
21            return 0;
22        }
23        
24        // Step 2: Check for sign
25        int sign = 1;
26        if (s.charAt(i) == '+') {
27            i++;
28        } else if (s.charAt(i) == '-') {
29            sign = -1;
30            i++;
31        }
32        
33        // Step 3: Read digits and convert
34        long res = 0;
35        while (i < n && Character.isDigit(s.charAt(i))) {
36            int digit = s.charAt(i) - '0';
37            res = res * 10 + digit;
38            
39            if (sign * res <= INT_MIN) {
40                return INT_MIN;
41            }
42            if (sign * res >= INT_MAX) {
43                return INT_MAX;
44            }
45            
46            i++;
47        }
48        
49        // Step 4: Apply sign and return
50        return (int)(res * sign);        
51    }
52}