// Last updated: 2/26/2026, 12:29:01 AM
1class Solution {
2    public int[] sortByBits(int[] arr) {
3        Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new);
4        Arrays.sort(temp, (a, b) -> {
5            int countA = Integer.bitCount(a);
6            int countB = Integer.bitCount(b); 
7            if (countA == countB) {
8                return a - b;
9            }
10            return countA - countB;
11        });   
12        for (int i = 0; i < arr.length; i++) {
13            arr[i] = temp[i];
14        }   
15        return arr;
16    }
17}