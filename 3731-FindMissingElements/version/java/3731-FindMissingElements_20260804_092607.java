// Last updated: 8/4/2026, 9:26:07 AM
1class Solution {
2    public List<Integer> findMissingElements(int[] nums) {
3        int min = Integer.MAX_VALUE;
4        int max = Integer.MIN_VALUE;
5        List<Integer> hi = new ArrayList<>();
6        for(int num : nums){
7            if(num < min)min = num;
8            if(num > max)max = num;
9            hi.add(num);
10        }
11        List<Integer> ni = new ArrayList<>();
12        for(int i = min; i < max+1; i++ ){
13            if(!hi.contains(i)){
14                ni.add(i);
15            }
16        }
17        return ni;
18    }
19}