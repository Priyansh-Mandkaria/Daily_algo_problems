// Last updated: 1/4/2026, 2:41:28 PM
1class Solution {
2    public int sumFourDivisors(int[] nums) {
3        int res = 0;
4
5        for(int num : nums){
6            if(sumOne(num) != -1)res+=sumOne(num);
7        }
8
9        return res;
10    }
11
12    private int sumOne(int n) {
13        // Case 1: p^3
14        int p = (int) Math.round(Math.cbrt(n));
15        if ((long) p * p * p == n && isPrime(p)) {
16            return 1 + p + p * p + p * p * p;
17        }
18
19        // Case 2: p * q
20        for (int i = 2; i * i <= n; i++) {
21            if (n % i == 0) {
22                int a = i;
23                int b = n / i;
24                if (a != b && isPrime(a) && isPrime(b)) {
25                    return 1 + a + b + n;
26                }
27                return -1;
28            }
29        }
30        return -1;
31    }
32
33    private boolean isPrime(int x) {
34        if (x < 2) return false;
35        for (int i = 2; i * i <= x; i++) {
36            if (x % i == 0) return false;
37        }
38        return true;
39    }
40}