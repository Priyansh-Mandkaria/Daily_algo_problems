// Last updated: 7/10/2025, 8:49:31 AM
class Solution {
    private int cal(String s1, String s2) {
        int len = Math.min(s1.length(), s2.length());
        int plen = 0;
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                plen++;
            } else {
                break;
            }
        }
        return plen;
    }
    public int[] longestCommonPrefix(String[] words) {
        int n = words.length;
        int[] arr = new int[n];
        if(n <= 2) return arr;
        int[] p = new int[n-1];
        for(int i = 0 ; i < n-1 ; i++){
            p[i] = cal(words[i],words[i+1]);
        }
        int[] pm = new int[n - 1];
        pm[0] = p[0];
        for (int i = 1; i < n - 1; i++) {
            pm[i] = Math.max(pm[i - 1], p[i]);
        }
        int[] sm = new int[n - 1];
        sm[n - 2] = p[n - 2];
        for (int i = n - 3; i >= 0; i--) {
            sm[i] = Math.max(sm[i + 1], p[i]);
        }
        for (int i = 0; i < n; i++) {
            int np = 0;
            if (i > 0 && i < n - 1) {
                np = cal(words[i - 1], words[i + 1]);
            }
            int r = 0;
            if (i > 1) {
                r = Math.max(r, pm[i - 2]);
            }
            if (i < n - 2) {
                r = Math.max(r, sm[i + 1]);
            }
            arr[i] = Math.max(np, r);
        }
        return arr;
    }
}