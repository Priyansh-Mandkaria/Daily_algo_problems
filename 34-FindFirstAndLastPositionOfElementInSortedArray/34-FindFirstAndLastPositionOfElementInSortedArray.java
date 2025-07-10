// Last updated: 7/10/2025, 8:59:33 AM
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findStartingPosition(nums, target);
        result[1] = findEndingPosition(nums, target);
        return result;
    }

    private int findStartingPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int start = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                start = mid;
                right = mid - 1; // Continue to search in the left half
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return start;
    }

    private int findEndingPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int end = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                end = mid;
                left = mid + 1; // Continue to search in the right half
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return end;
    }
}
