// Last updated: 7/10/2025, 8:54:41 AM
class Solution {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        int sum = 0;
        for (int num : freqMap.keySet()) {
            if (freqMap.get(num) == 1) {
                sum += num;
            }
        }
        return sum;
    }
}