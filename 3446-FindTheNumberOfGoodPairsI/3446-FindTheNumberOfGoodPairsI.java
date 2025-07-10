// Last updated: 7/10/2025, 8:51:04 AM
class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int count = 0;
        for(int i = 0; i < nums1.length ; i ++ ){
            for(int j = 0; j < nums2.length ; j++){
                int d = nums2[j] * k;
                if(nums1[i] % d == 0){
                    count++;
                }
            }
        }
        return count;
    }
}