// Last updated: 6/22/2026, 1:37:50 PM
class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int knew = k - 1;
        if (knew == 0) return true;
        for (int j = k + 1; j < nums.size(); j++) {
            if (nums.get(j) > nums.get(j - 1) && nums.get(j - k) > nums.get(j - k - 1)) {
                knew--;
            } else {
                knew = k - 1;
            }
            if (knew == 0) return true;
        }
        return false;
    }
}