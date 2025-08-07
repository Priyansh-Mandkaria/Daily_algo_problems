// Last updated: 8/7/2025, 6:57:16 PM
// Easy Pure Question on Binary Search on Answers
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 1;
        int high = arr[arr.length-1]+k;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(miss(arr, mid) < k){
                low = mid + 1;
            }
            else{
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }
    public int miss(int[]arr ,int mid){
        int count = 0;
        for (int num : arr) {
            if (num <= mid) count++;
        }
        return mid - count;
    }
}