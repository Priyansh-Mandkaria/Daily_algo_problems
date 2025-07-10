// Last updated: 7/10/2025, 8:53:31 AM
class Solution {
    public String[] divideString(String s, int k, char fill) {
        StringBuilder sb = new StringBuilder(s);

        while (sb.length() % k != 0) {
            sb.append(fill);
        }

        String res[] = new String[sb.length() / k];
        for (int i = 0; i < sb.length() / k; i++) {
            res[i] = sb.substring(i * k, (i + 1) * k);
        }

        return res;
    }
}