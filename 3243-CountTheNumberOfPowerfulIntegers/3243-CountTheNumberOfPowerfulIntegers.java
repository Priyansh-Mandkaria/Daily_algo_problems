// Last updated: 7/10/2025, 8:51:32 AM
class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String l = Long.toString(start - 1);
        String r = Long.toString(finish);
        return help(r, s, limit, r.length(), s.length()) - help(l, s, limit, l.length(), s.length());
    }
    long help(String range, String s, int lim, int n, int m) {
        if (n < m)
            return 0;
        if (n == m)
            return range.compareTo(s) >= 0 ? 1 : 0;
        String suffix = range.substring(n - m);
        long count = 0;
        int preLen = n - m;
        for (int i = 0; i < preLen; i++) {
            int digit = range.charAt(i) - '0';
            if (lim < digit) {
                count += (long) Math.pow(lim + 1, preLen - i);
                return count;
            }
            count += (long) digit * (long) Math.pow(lim + 1, preLen - 1 - i);
        }
        if (suffix.compareTo(s) >= 0) {
            count++;
        }
        return count;
    }
}