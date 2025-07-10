// Last updated: 7/10/2025, 8:58:09 AM
class Solution {
    public List<String> summaryRanges(int[] arr) {
        List<String> result = new ArrayList<>();
        int n = arr.length;
        if (n == 0) return result;
        int start = 0;
        for (int i = 1; i <= n; i++) {
            if (i == n || arr[i] != arr[i - 1] + 1) {
                if (start == i - 1)result.add(String.valueOf(arr[start]));
                else result.add(arr[start] + "->" + arr[i - 1]);
                start = i;
            }
        }
        return result;
     }
}