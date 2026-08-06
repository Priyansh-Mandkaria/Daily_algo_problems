// Last updated: 8/6/2026, 10:06:51 AM
1class Solution {
2    public static int smallestNumber(int n, int t) {
3        while (true) {
4            int multi = digitProduct(n);
5            if (multi % t == 0) {
6                return n;
7            }
8            n++;
9        }
10    }
11    private static int digitProduct(int num) {
12        int product = 1;
13        while (num > 0) {
14            int digit = num % 10;
15            product *= digit;
16            num /= 10;
17            if (product == 0) {
18                return 0;
19            }
20        }
21        return product;
22    }
23    
24    
25}