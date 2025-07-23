// Last updated: 7/23/2025, 7:08:10 PM
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> map=new HashMap<>();
        int prefixSum=0;
        int cnt=0;
        map.put(0, 1);
        for(int i=0;i<nums.length;i++)
        {
            prefixSum+=nums[i]%2;
            if(map.containsKey(prefixSum-k))
            {
                cnt+=map.get(prefixSum-k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0)+1);
        }
        return cnt;
    }
}