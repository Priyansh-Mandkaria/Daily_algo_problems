// Last updated: 7/10/2025, 8:58:21 AM
// class Solution {
//     public int rob(int[] nums) {
//        // we can think as either robber rob even house or odd house 
//        // now we do first even house and then odd house
//        int n = nums.length;
//        if( n == 0){
//         return 0;
//        }
//        int sum1 = 0;
//        int sum2 = 0;
//         for(int i = 0 ; i < n ; i = i + 2){
//             sum1 = sum1 + nums[i];
//         }
//         for(int i = 1 ; i < n ; i = i + 2){ 
//             sum2 = sum2 + nums[i];
//         }
//         if ( sum1 > sum2){
//             return sum1;
//         }
//         return sum2;
//     }
// }
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        
        return dp[n-1];
    }
}
// class Solution {
//     public int rob(int[] nums) {
//         if (nums == null || nums.length == 0) {
//             return 0;
//         }
//         if (nums.length == 1) {
//             return nums[0];
//         }
        
//         int prev2 = 0;  // max money robbed up to house n-2
//         int prev1 = nums[0];  // max money robbed up to house n-1
        
//         for (int i = 1; i < nums.length; i++) {
//             int current = Math.max(prev1, nums[i] + prev2);
//             prev2 = prev1;
//             prev1 = current;
//         }
        
//         return prev1;
//     }
// }
