// Last updated: 1/1/2026, 12:34:06 PM
1class Solution {
2    public int[] plusOne(int[] digits) {
3        int n = digits.length;
4        ArrayList<Integer> list = new ArrayList<>();
5        int carry = 1; 
6        for (int i = n - 1; i >= 0; i--) {
7            int sum = digits[i] + carry;
8            if (sum >= 10) {
9                list.add(0);
10            } else {
11                list.add(sum);
12                carry = 0;
13            }
14        }
15        if (carry == 1) {
16            list.add(1);
17        }
18        Collections.reverse(list);
19        int[] arr = new int[list.size()];
20        for (int i = 0; i < list.size(); i++) {
21            arr[i] = list.get(i);
22        }
23        return arr;
24    }
25}
26