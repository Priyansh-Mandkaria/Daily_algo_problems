// Last updated: 8/5/2025, 3:26:23 PM
/*
 * Simple BS on ans . with new concept of ciel for int :- 
 *  (arr[i] + h -1)/h == ciel value for arr[i]/h . if use Math.ciel it does not matter for int . because int give integer and ciel is same only . so we will get wrong answers. so we use this functions for float type
*/

class Solution {
    public int smallestDivisor(int[] arr, int k) {
        // Binary Search on Answers
        int ans = 0;
        int low = 1;
        int high = Arrays.stream(arr).max().getAsInt();
        while(low <= high){
            int mid = low + (high - low)/2;
            if(check(arr,k,mid) <= k){
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }
    private int check(int[] arr, int k , int h){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            /* We can use Math.ciel(arr[i]/h) but it does not make sense
            we have to do in float and than ciel so another trick just for int */
            sum += (arr[i] + h - 1)/h;
        }
        return sum;
    }
}