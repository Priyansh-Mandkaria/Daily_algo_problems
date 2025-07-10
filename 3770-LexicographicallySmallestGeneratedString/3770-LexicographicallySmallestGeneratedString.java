// Last updated: 7/10/2025, 8:49:40 AM
class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length(), m = str2.length(), L = n + m - 1;
        char[] word = new char[L];
        boolean[] forced = new boolean[L];
        Arrays.fill(word, '\0');
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    int pos = i + j;
                    char c = str2.charAt(j);
                    if (word[pos] == '\0') {
                        word[pos] = c;
                        forced[pos] = true;
                    } else if (word[pos] != c) {
                        return "";
                    }
                }
            }
        }
        for (int i = 0; i < L; i++) {
            if (word[i] == '\0') {
                word[i] = 'a';
            }
        }
        boolean modified = true;
        while (modified) {
            modified = false;
            for (int i = 0; i < n; i++) {
                if (str1.charAt(i) == 'F') {
                    boolean eq = true;
                    for (int j = 0; j < m; j++) {
                        if (word[i + j] != str2.charAt(j)) {
                            eq = false;
                            break;
                        }
                    }
                    if (eq) {
                        boolean done = false;
                        for (int j = m - 1; j >= 0; j--) {
                            int pos = i + j;
                            if (!forced[pos]) {
                                for (char c = (char) (word[pos] + 1); c <= 'z'; c++) {
                                    if (c != str2.charAt(j)) {
                                        word[pos] = c;
                                        for (int k = pos + 1; k < L; k++) {
                                            if (!forced[k]) {
                                                word[k] = 'a';
                                            }
                                        }
                                        done = true;
                                        break;
                                    }
                                }
                                if (done)
                                    break;
                            }
                        }
                        if (!done)
                            return "";
                        modified = true;
                        break;
                    }
                }
            }
        }
        return new String(word);
    }
}