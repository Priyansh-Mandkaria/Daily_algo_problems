// Last updated: 7/10/2025, 8:55:22 AM
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandy = Integer.MIN_VALUE;
        for (int candy : candies) {
            maxCandy = Math.max(maxCandy, candy);
        }
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            result.add(candies[i] + extraCandies >= maxCandy);
        }
        return result;
    }
}