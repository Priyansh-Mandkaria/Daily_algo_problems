// Last updated: 3/29/2026, 3:28:54 PM
1class Solution {
2    public int[] twoSum(int[] nums, int target) {
3        Map< Integer , Integer > map = new HashMap<>();
4        for (int i =0 ; i< nums.length ; i++){
5            int cur = nums[i];
6            int x = target - cur;
7            if(map.containsKey(x))
8            {
9                return new int[] { map.get(x),i};
10            }
11            map.put(cur,i);
12        }
13        return null;
14    }
15}