// Last updated: 7/10/2025, 8:58:05 AM
// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int[] answer = new int[nums.length];
//         for(int i = 0 ; i < nums.length; i++){
//             if( i == 0){
//                 answer[i] = mul2(i,nums);
//             }
//             else if( i > 0 && i < nums.length-1){
//                 answer[i] = mul1(i,nums) * mul2(i,nums);
//             }
//             else if( i == nums.length-1){
//                 answer[i] = mul1(i,nums);
//             }
//         }
//         return answer;
//     }
//     public static int mul1(int n, int[] nums){//product which is less that number
//         int product1 = 1;
//         for(int j = 0 ; j < n ; j++){
//             product1 = product1 * nums[j];
//         }
//         return product1;
//     }
//     public static int mul2(int n, int[] nums){//product which is more that number
//         int product2 = 1;
//         for(int j = n + 1  ; j < nums.length ; j++){
//             product2 = product2 * nums[j];
//         }
//         return product2;
//     }
// }
// This solution is correct but time limit exceed...
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        
        // Initialize the answer array with 1's
        for (int i = 0; i < n; i++) {
            answer[i] = 1;
        }
        
        // Compute the products of all elements to the left of each element
        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            answer[i] *= leftProduct;
            leftProduct *= nums[i];
        }
        
        // Compute the products of all elements to the right of each element
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        
        return answer;
    }
}
