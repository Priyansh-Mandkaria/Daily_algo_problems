// Last updated: 7/10/2025, 8:58:33 AM
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1}; 
            } else if (sum < target) {
                left++; 
            } else {
                right--;
            }
        }
        return new int[]{};
    }
}