// Last updated: 2/27/2026, 12:57:06 AM
1import java.math.BigInteger;
2class Solution {
3    public int numSteps(String s) {
4       BigInteger num = new BigInteger(s, 2);
5        int steps = 0;
6        while (!num.equals(BigInteger.ONE)) {
7            if (num.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
8                num = num.divide(BigInteger.TWO);
9            } else {
10                num = num.add(BigInteger.ONE);
11            }
12            steps += 1;
13        }
14        return steps;
15    }
16}