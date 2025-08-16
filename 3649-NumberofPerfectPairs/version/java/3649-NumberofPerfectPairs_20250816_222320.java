// Last updated: 8/16/2025, 10:23:20 PM
class Solution {
    public long perfectPairs(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) nums[i] = Math.abs(nums[i]);
        Arrays.sort(nums);
        long count = 0;
        for(int i = 0; i < n; i++) {
            int low = i + 1;
            int high = n - 1;
            int ans = i;
            while(low <= high) {
                int mid = (low + high) / 2;
                if(nums[mid] <= 2L * nums[i]) {
                    ans = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            count += ans - i;
        }
        return count;
    }
}