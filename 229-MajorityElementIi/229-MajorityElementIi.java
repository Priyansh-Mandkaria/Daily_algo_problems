// Last updated: 7/10/2025, 8:58:08 AM
class Solution {
    public List<Integer> majorityElement(int[] arr) {
        ArrayList<Integer> mc = new ArrayList<>();
        int n = arr.length;
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (visited.contains(arr[i])) continue;
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count > n / 3) {
                mc.add(arr[i]);
            }
            visited.add(arr[i]);
        }
        return mc;
    }
}