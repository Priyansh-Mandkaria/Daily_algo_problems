// Last updated: 6/22/2026, 1:35:21 PM
class Solution {
    public int minRemoval(int[] arr, int k) {
        Arrays.sort(arr);
        int cnt = 0;
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            while(cnt <= i && (long)arr[i] > (long)arr[cnt]*k) cnt++;
            max = Math.max(max,i-cnt+1);
        }
        int j = arr.length - max;
        return j;
    }
}