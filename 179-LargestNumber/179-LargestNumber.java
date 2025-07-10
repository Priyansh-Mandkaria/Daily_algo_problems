// Last updated: 7/10/2025, 8:58:30 AM
class Solution {
    public String largestNumber(int[] nums) {
        String[] numStrings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numStrings, (a, b) -> (b + a).compareTo(a + b));
        if (numStrings[0].equals("0")) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        for (String num : numStrings) {
            result.append(num);
        }
        return result.toString();
    }
}