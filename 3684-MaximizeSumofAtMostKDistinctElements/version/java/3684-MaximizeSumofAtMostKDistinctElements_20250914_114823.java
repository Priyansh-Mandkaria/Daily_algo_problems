// Last updated: 9/14/2025, 11:48:23 AM
class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        int ind = 1;
        res.add(nums[n-1]);
        for(int i = n - 2 ; i >= 0 && ind < k; i--){
            while( i > 0 && nums[i] == nums[i+1]) i--;
            if(nums[i] != res.get(ind-1)){
                res.add(nums[i]);
                ind++;
            }
        }
        int size = res.size();
        int[] ans = new int[size];
        for(int i = 0 ; i < size ; i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}