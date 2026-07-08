// Last updated: 7/8/2026, 11:43:27 AM
1class Solution {
2    public List<Integer> grayCode(int n) {
3        List<Integer> answer = new ArrayList<>(); 
4        for (int i = 0; i < 1 << n; i++) answer.add(i ^ (i >> 1));
5        return answer;
6    }
7}