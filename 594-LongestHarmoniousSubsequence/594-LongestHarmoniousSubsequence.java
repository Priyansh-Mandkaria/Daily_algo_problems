// Last updated: 7/10/2025, 8:57:20 AM
class Solution {
    public int findLHS(int[] arr) {
        // HashMap<Integer, Integer> freq = new HashMap<>();
        // for (int num : arr) {
        //     freq.put(num, freq.getOrDefault(num, 0) + 1);
        // }
        // int maxLen = 0;
        // for (int key : freq.keySet()) {
        //     if (freq.containsKey(key + 1)) {
        //         maxLen = Math.max(maxLen, freq.get(key) + freq.get(key + 1));
        //     }
        // }
        // return maxLen;
        Arrays.sort(arr);
        int start = 0, maxLen = 0;
        for (int end = 0; end < arr.length; end++) {
            while (arr[end] - arr[start] > 1) {
                start++;
            }
            if (arr[end] - arr[start] == 1) {
                maxLen = Math.max(maxLen, end - start + 1);
            }
        }
        return maxLen;
    }
}