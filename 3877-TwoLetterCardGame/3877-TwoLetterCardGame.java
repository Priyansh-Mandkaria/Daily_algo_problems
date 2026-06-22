// Last updated: 6/22/2026, 1:36:03 PM
import java.util.*;

class Solution {
    public int score(String[] c, char x) {
        Map<Character, Integer> g0 = new HashMap<>();
        Map<Character, Integer> g1 = new HashMap<>();
        int xx = 0;

        for (String s : c) {
            char a = s.charAt(0), b = s.charAt(1);
            if (a == x && b == x) xx++;
            else if (a == x) g0.put(b, g0.getOrDefault(b, 0) + 1);
            else if (b == x) g1.put(a, g1.getOrDefault(a, 0) + 1);
        }

        int pInt = 0, l = 0;

        if (!g0.isEmpty()) {
            int s = 0, m = 0;
            for (int v : g0.values()) { s += v; if (v > m) m = v; }
            int p0 = (2 * m > s) ? s - m : s / 2;
            pInt += p0;
            l += s - 2 * p0;
        }

        if (!g1.isEmpty()) {
            int s = 0, m = 0;
            for (int v : g1.values()) { s += v; if (v > m) m = v; }
            int p1 = (2 * m > s) ? s - m : s / 2;
            pInt += p1;
            l += s - 2 * p1;
        }

        int p = pInt;
        int extra = Math.min(l, xx);
        p += extra;
        int leftXx = xx - extra;
        p += Math.min(pInt, leftXx / 2);

        return p;
    }
}
