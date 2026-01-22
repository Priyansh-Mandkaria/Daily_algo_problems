// Last updated: 1/22/2026, 11:54:25 AM
1class Solution {
2    public int minPair(List<Integer> v) {
3        int minSum = (int)1e9;
4        int pos = -1;
5        for(int i = 0; i < v.size() - 1; i ++){
6            int sum = v.get(i) + v.get(i + 1);
7            if (sum < minSum) {
8                minSum = sum;
9                pos = i;
10            }
11        }
12        return pos;
13    }
14    public void mergePair(List<Integer> v, int pos) {
15        v.set(pos, v.get(pos) + v.get(pos + 1));
16        v.remove(pos + 1);
17    }
18    public int minimumPairRemoval(int[] nums) {
19        List<Integer> v = new ArrayList<>();
20        for(int x : nums) v.add(x);
21
22        int ops = 0;
23        while(!isSorted(v)){
24            int pos = minPair(v);
25            mergePair(v, pos);
26            ops++;
27        }
28        return ops;
29    }
30    private boolean isSorted(List <Integer> v) {
31        for(int i = 0; i < v.size() - 1; i ++){
32            if(v.get(i) > v.get(i + 1)) return false;
33        }
34        return true;
35    }
36}