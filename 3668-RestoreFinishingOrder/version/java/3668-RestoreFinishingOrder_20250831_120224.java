// Last updated: 8/31/2025, 12:02:24 PM
class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {

        List<Integer> result = new ArrayList();

        for (var num : order) {
            var index = BinarySearch(friends, num);
            if (index < 0) continue;
            result.add(friends[index]);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    private int BinarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}