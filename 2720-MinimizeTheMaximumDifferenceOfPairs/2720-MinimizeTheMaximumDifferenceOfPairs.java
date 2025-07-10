// Last updated: 7/10/2025, 8:52:19 AM
class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int i= 0;
        int j = nums[nums.length -1] - nums[0];

        while(i < j){
            int mid = i + (j-i)/2;

            if(Pairs(nums , p ,mid)){
                j  = mid ;
            }else{
                i = mid + 1;
            }
        }
        return i ;
    }
    private boolean Pairs(int[] nums,int p,int maxdiff){
        int count = 0 , i = 1;
        while(i < nums.length){
            if(nums[i] - nums[i-1] <= maxdiff){
                count++;
                i+=2;
            }else{
                i++;
            }
        }
        return count >= p ;
    }
}