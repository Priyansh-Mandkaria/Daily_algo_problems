// Last updated: 7/10/2025, 8:51:23 AM
class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        for (int val : count.values()) {
            if (val > 2) {
                return false;
            }
        }  
        return true;        
    }
}