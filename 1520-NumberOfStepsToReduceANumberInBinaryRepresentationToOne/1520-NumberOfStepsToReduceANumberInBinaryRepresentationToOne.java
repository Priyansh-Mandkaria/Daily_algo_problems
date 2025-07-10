// Last updated: 7/10/2025, 8:55:24 AM
import java.math.BigInteger;
class Solution {
    public int numSteps(String s) {
       BigInteger num = new BigInteger(s, 2);
        int steps = 0;
        while (!num.equals(BigInteger.ONE)) {
            if (num.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
                num = num.divide(BigInteger.TWO);
            } else {
                num = num.add(BigInteger.ONE);
            }
            steps += 1;
        }
        return steps;
    }
}