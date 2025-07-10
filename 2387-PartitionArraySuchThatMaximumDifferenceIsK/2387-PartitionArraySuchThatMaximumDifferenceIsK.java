// Last updated: 7/10/2025, 8:53:15 AM
class Solution {
    public int partitionArray(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = -100001;
        for(int x : nums)
        max = Math.max(max, x);
        int freq[] = new int[max+1];
        for(int x : nums){
            freq[x]++;
        }
        int ans = 0; 
        for(int i=0 ; i<=max; i++){
            if(freq[i]>0 && i-min>k){
                min = i; 
                ans++; 
            }  
        }
    return ans;
    }
}