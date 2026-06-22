// Last updated: 6/22/2026, 1:35:31 PM
class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] lengths = new long[n + 1];  // length after each operation
        lengths[0] = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                lengths[i + 1] = lengths[i] + 1;
            } else if (ch == '*') {
                lengths[i + 1] = Math.max(0, lengths[i] - 1);
            } else if (ch == '#') {
                if (lengths[i] * 2 >= 1e15) 
                    lengths[i + 1] = (long) 1e15;  // avoid overflow
                else
                    lengths[i + 1] = lengths[i] * 2;
            } else if (ch == '%') {
                lengths[i + 1] = lengths[i];
            }
        }

        if (k >= lengths[n]) return '.';

        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if (k == lengths[i]) return ch;
                else if (k < lengths[i]) continue;
            } else if (ch == '*') {
                if (k >= lengths[i]) k++;  // simulate deletion, adjust forward
            } else if (ch == '#') {
                if (k >= lengths[i]) {
                    if (k < 2 * lengths[i]) {
                        k = k % lengths[i];  // find where it came from
                    }
                }
            } else if (ch == '%') {
                if (lengths[i] > 0)
                    k = lengths[i] - 1 - k;
            }
        }

        return '.';  // shouldn't reach here
    }
}