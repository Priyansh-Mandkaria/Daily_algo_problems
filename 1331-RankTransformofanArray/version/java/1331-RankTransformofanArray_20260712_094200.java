// Last updated: 7/12/2026, 9:42:00 AM
1class Solution {
2    public int[] arrayRankTransform(int[] arr) {
3        int[] sortedarr = arr.clone();
4        Arrays.sort(sortedarr);
5        Map<Integer, Integer> ranks = new HashMap<>();
6        int rank = 1;
7        for (int x : sortedarr) {
8            if (!ranks.containsKey(x)) {
9                ranks.put(x, rank);
10                rank++;
11            }
12        }
13        for (int i = 0; i < arr.length; i++) {
14            arr[i] = ranks.get(arr[i]);
15        }
16        return arr;
17    }
18}