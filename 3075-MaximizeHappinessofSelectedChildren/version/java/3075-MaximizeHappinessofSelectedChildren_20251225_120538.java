// Last updated: 12/25/2025, 12:05:38 PM
import java.util.*;

class Solution {

    void countSort(int[] hap, int p) {
        int[] cnt = new int[10];

        // count digit frequency
        for (int x : hap) {
            int d = (x / p) % 10;
            cnt[d]++;
        }

        // prefix sum
        for (int i = 1; i < 10; i++)
            cnt[i] += cnt[i - 1];

        int n = hap.length;
        int[] out = new int[n];

        // stable placement (right to left)
        for (int i = n - 1; i >= 0; i--) {
            int d = (hap[i] / p) % 10;
            out[cnt[d] - 1] = hap[i];
            cnt[d]--;
        }

        System.arraycopy(out, 0, hap, 0, n);
    }

    void radix(int[] hap) {
        int mx = 0;
        for (int x : hap) mx = Math.max(mx, x);

        for (int p = 1; mx / p > 0; p *= 10)
            countSort(hap, p);
    }

    public long maximumHappinessSum(int[] hap, int k) {
        radix(hap); // ascending

        long ans = 0;
        int time = 0;
        int n = hap.length;

        for (int i = n - 1; i >= n - k; i--) {
            long add = hap[i] - time;
            if (add <= 0) break;
            ans += add;
            time++;
        }
        return ans;
    }
}
