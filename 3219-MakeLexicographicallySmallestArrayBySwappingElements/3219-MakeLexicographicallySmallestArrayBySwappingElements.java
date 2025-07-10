// Last updated: 7/10/2025, 8:51:36 AM
class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
       int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int currentG = 0;
        Map<Integer, Integer> numToGroup = new HashMap<>();
        Map<Integer, LinkedList<Integer>> groupToList = new HashMap<>();
        numToGroup.put(sorted[0], currentG);
        groupToList.put(currentG, new LinkedList<>(Arrays.asList(sorted[0])));
        for (int i = 1; i < n; i++) {
            if (Math.abs(sorted[i] - sorted[i - 1]) > limit) {
                currentG++;
            }
            numToGroup.put(sorted[i], currentG);
            groupToList.putIfAbsent(currentG, new LinkedList<>());
            groupToList.get(currentG).add(sorted[i]);
        }
        for (int i = 0; i < n; i++) {
            int group = numToGroup.get(nums[i]);
            nums[i] = groupToList.get(group).poll();
        }
        return nums; 
    }
}