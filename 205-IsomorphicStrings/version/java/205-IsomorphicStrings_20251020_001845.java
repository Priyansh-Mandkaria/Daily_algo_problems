// Last updated: 10/20/2025, 12:18:45 AM
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] mapST = new char[256];
        char[] mapTS = new char[256];

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (mapST[sc] == 0 && mapTS[tc] == 0) {
                mapST[sc] = tc;
                mapTS[tc] = sc;
            } else {
                if (mapST[sc] != tc || mapTS[tc] != sc)
                    return false;
            }
        }
        return true;
    }
}
