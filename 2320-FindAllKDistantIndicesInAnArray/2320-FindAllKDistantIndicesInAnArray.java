// Last updated: 7/10/2025, 8:53:18 AM
class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        int n = nums.length;
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < n ; j++){
                if(nums[j] == key && Math.abs(i-j) <= k){
                    arr.add(i);
                    break;
                }
            }
        }
        return arr;
    }
}