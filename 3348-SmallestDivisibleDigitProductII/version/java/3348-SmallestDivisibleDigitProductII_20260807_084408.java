// Last updated: 8/7/2026, 8:44:08 AM
1class Solution {
2    int primes[] = new int[] { 2, 3, 5, 7 };
3    int maxPrime = primes[primes.length - 1];
4
5    public String smallestNumber(String num, long t) {
6        int primeCount[] = new int[maxPrime + 1];
7        int numLength = num.length();
8        int minLength;
9        int firstZeroIndexFromLeft = 0;
10
11        for (int prime : primes) {
12            while (t % prime == 0) {
13                t /= prime;
14                primeCount[prime]++;
15            }
16        }
17
18        if (t != 1) {
19            return "-1";
20        }
21
22        minLength = getMinLength(primeCount);
23
24        if (numLength < minLength) {
25            return buildSuffix(primeCount, minLength, new char[minLength]);
26        }
27
28        char[] result = new char[numLength + 1];
29
30        for (int i = 0; firstZeroIndexFromLeft < numLength
31                && (result[++i] = num.charAt(firstZeroIndexFromLeft)) != '0'; firstZeroIndexFromLeft++) {
32            logNum(primeCount, result[i], -1);
33        }
34
35        if (getMinLength(primeCount) == 0) {
36            if (firstZeroIndexFromLeft == numLength) {
37                return num;
38            }
39            Arrays.fill(result, ++firstZeroIndexFromLeft, result.length, '1');
40            return new String(result, 1, numLength);
41        }
42
43        for (int last = numLength - 1, end = Math.min(firstZeroIndexFromLeft, last); end >= 0; end--) {
44            for (logNum(primeCount, result[end + 1], 1); ++result[end + 1] <= '9'; logNum(primeCount, result[end + 1], 1)) {
45                logNum(primeCount, result[end + 1], -1);
46                if (getMinLength(primeCount) <= last - end) {
47                    return buildSuffix(primeCount, last - end, result);
48                }
49            }
50        }
51
52        return buildSuffix(primeCount, result.length, result);
53    }
54
55    void logNum(int[] primeCount, int num, int value) {
56        if (num < '2') {
57            return;
58        }
59
60        if (num == '9') {
61            primeCount[3] += value << 1;
62        } else if (num == '4') {
63            primeCount[2] += value << 1;
64        } else if (num == '8') {
65            primeCount[2] += value * 3;
66        } else if (num == '6') {
67            primeCount[2] += value;
68            primeCount[3] += value;
69        } else {
70            primeCount[num - '0'] += value;
71        }
72    }
73
74    String buildSuffix(int[] primeCount, int targetLength, char[] result) {
75        int index = result.length;
76
77        while (primeCount[3] > 1) {
78            primeCount[3] -= 2;
79            result[--index] = '9';
80        }
81
82        while (primeCount[2] > 2) {
83            primeCount[2] -= 3;
84            result[--index] = '8';
85        }
86
87        while (primeCount[7]-- > 0) {
88            result[--index] = '7';
89        }
90
91        if (primeCount[2] > 0 && primeCount[3] > 0) {
92            result[--index] = '6';
93            primeCount[2]--;
94            primeCount[3]--;
95        }
96
97        while (primeCount[5]-- > 0) {
98            result[--index] = '5';
99        }
100
101        while (primeCount[2] > 1) {
102            primeCount[2] -= 2;
103            result[--index] = '4';
104        }
105
106        while (primeCount[3] > 0) {
107            primeCount[3]--;
108            result[--index] = '3';
109        }
110
111        while (primeCount[2] > 0) {
112            primeCount[2]--;
113            result[--index] = '2';
114        }
115
116        while (index + targetLength != result.length) {
117            result[--index] = '1';
118        }
119
120        return targetLength == result.length ? new String(result) : new String(result, 1, result.length - 1);
121    }
122
123    int getMinLength(int[] primeCount) {
124        int count2 = Math.max(0, primeCount[2]);
125        int count3 = Math.max(0, primeCount[3]);
126        int count23 = (count3 & 1) + (count2 % 3);
127
128        return (count3 >> 1) + (count2 / 3) + Math.max(0, primeCount[7]) + Math.max(0, primeCount[5])
129                + (count23 == 3 ? 2 : count23 > 0 ? 1 : 0);
130    }
131}