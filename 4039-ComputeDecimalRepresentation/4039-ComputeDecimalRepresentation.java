// Last updated: 6/22/2026, 1:34:20 PM
class Solution {
    public int[] decimalRepresentation(int n) {
        String s = String.valueOf(n);
        return java.util.stream.IntStream.range(0, s.length())
                .filter(i -> s.charAt(i) != '0')
                .map(i -> (s.charAt(i) - '0') * (int) Math.pow(10, s.length() - 1 - i))
                .toArray();
    }
}