// Last updated: 10/24/2026, 9:34:38 AM
1class Solution {
2    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
3        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
4        int aStart = toDay(arriveAlice, days);
5        int aEnd = toDay(leaveAlice, days);
6        int bStart = toDay(arriveBob, days);
7        int bEnd = toDay(leaveBob, days);
8        int start = Math.max(aStart, bStart);
9        int end = Math.min(aEnd, bEnd);
10        return start <= end ? end - start + 1 : 0;
11    }
12    private int toDay(String s, int[] days) {
13        int m = (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0');
14        int d = (s.charAt(3) - '0') * 10 + (s.charAt(4) - '0');
15        int res = d;
16        for (int i = 0; i < m - 1; i++) res += days[i];
17        return res;
18    }
19}