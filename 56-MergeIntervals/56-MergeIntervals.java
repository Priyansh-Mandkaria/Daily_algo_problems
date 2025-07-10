// Last updated: 7/10/2025, 8:59:12 AM
import java.util.*;
class Solution {
    public int[][] merge(int[][] arr) {
        if (arr.length <= 1) return arr;
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));//comparator sort
        List<int[]> result = new ArrayList<>();
        int start = arr[0][0];
        int end = arr[0][1];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] <= end) {
                end = Math.max(end, arr[i][1]);
            } else {
                result.add(new int[]{start, end});
                start = arr[i][0];
                end = arr[i][1];
            }
        }
        result.add(new int[]{start, end});
        return result.toArray(new int[result.size()][]);
    }
}
