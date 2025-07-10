// Last updated: 7/10/2025, 8:55:08 AM
class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        final int MOD = 1000000007;
        ArrayList<Integer> subarraySums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                subarraySums.add(sum);
            }
        }
        Collections.sort(subarraySums);
        long result = 0;
        for (int i = left - 1; i < right; i++) {
            result = (result + subarraySums.get(i)) % MOD;
        }
        return (int) result;
    }
}