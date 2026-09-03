// Last updated: 9/3/2026, 7:48:04 AM
1class Solution {
2    public boolean uniformArray(int[] nums) {
3        int smallestOdd = Integer.MAX_VALUE;
4        for (int num : nums) {
5            if (num % 2 == 1)
6                smallestOdd = Math.min(smallestOdd, num);
7        }
8        if (smallestOdd == Integer.MAX_VALUE)
9            return true;
10        for (int num : nums) {
11            if (num % 2 == 0 && num <= smallestOdd)
12                return false;
13        }
14        return true;
15    }
16}