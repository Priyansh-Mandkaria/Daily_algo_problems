// Last updated: 7/10/2025, 9:00:06 AM
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map< Integer , Integer > map = new HashMap<>();
        for (int i =0 ; i< nums.length ; i++){
            int cur = nums[i];
            int x = target - cur;
            if(map.containsKey(x))
            {
                return new int[] { map.get(x),i};
            }
            map.put(cur,i);
        }
        return null;
    }
}