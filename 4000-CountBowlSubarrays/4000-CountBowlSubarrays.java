// Last updated: 6/22/2026, 1:34:43 PM
class Solution {
    public long bowlSubarrays(int[] nums) {
        int l = nums.length;
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < l; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int mid = stack.pop();
                if (!stack.isEmpty()) {
                    int left = stack.peek();
                    if (Math.min(nums[left], nums[i]) > nums[mid])
                        ++ans;
                }
            }
            stack.push(i);
        }
        return ans;
    }
}