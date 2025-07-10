// Last updated: 7/10/2025, 8:49:59 AM
class Solution {
    public int largestInteger(int[] nums, int k) {
        int[] freq = new int[51];
        for(int i = 0; i <= nums.length - k; i++) {
            Set<Integer> set = new HashSet<>();
            for(int j = i; j < i + k; j++) set.add(nums[j]);
            for(int key : set) freq[key]++;
        }
        for(int i = 50; i >= 0; i--) {
            if(freq[i] == 1) return i;
        }
        return -1;
    }
}