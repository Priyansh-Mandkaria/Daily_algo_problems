// Last updated: 7/10/2025, 8:59:03 AM
import java.math.BigInteger;
class Solution {
    public String addBinary(String a, String b) {
        BigInteger p = new BigInteger(a,2);
        BigInteger q = new BigInteger(b,2);
        BigInteger r = p.add(q);
        return r.toString(2);
    }
}