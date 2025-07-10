// Last updated: 7/10/2025, 8:50:31 AM
class Solution {
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            int sumOfDigits = getSumOfDigits(num);
            min = Math.min(min, sumOfDigits);
        }
        return min;
    }

    private int getSumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
}
