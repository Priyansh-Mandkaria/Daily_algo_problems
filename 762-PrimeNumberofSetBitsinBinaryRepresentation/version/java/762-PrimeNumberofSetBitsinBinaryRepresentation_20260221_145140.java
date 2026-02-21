// Last updated: 2/21/2026, 2:51:40 PM
1class Solution {
2    private static int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19};
3
4    private int comb(int n, int k) {
5        if (n <= 0 || k <= 0 || k > n) return 0;
6
7        long f1 = 1, f2 = 1;
8        for (int i = k + 1; i <= n; i++) {
9            f1 *= i;
10        }
11
12        for (int i = 2; i <= n - k; i++) {
13            f2 *= i;
14        }
15
16        return (int) (f1 / f2);
17    }
18
19    private int countValid(int av, int al) {
20        int count = 0;
21        for (int prime : PRIMES) {
22            int need = prime - al;
23            if (need < 0 || need > av) {
24                continue;
25            }
26            count += comb(av, need);
27        }
28
29        return count;
30    }
31
32    private int countPrimes(int num) {
33        for (int i = PRIMES.length - 1; i >= 0; i--) {
34            if (num >= PRIMES[i]) {
35                return i + 1;
36            }
37        }
38        return 0;
39    }
40
41    private int countNum(int num) {
42        if (num == 0) return 0;
43
44        int mask = 0x40000000;
45        int pos = 31, curr = 0, total = 0;
46        while (mask != 0) {
47            if ((num & mask) != 0) {
48                total += countValid(pos - 1, curr);
49                curr++;
50            }
51            mask >>>= 1;
52            pos--;
53        }
54
55        total += countPrimes(curr);
56        return total;
57    }
58
59    public int countPrimeSetBits(int left, int right) {
60        return countNum(right) - countNum(left - 1);
61    }
62}