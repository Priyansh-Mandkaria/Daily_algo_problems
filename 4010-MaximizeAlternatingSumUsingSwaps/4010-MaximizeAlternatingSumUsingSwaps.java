// Last updated: 6/22/2026, 1:34:34 PM
class Solution {
    private int[] parent;

    private int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }

    private void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) parent[rootI] = rootJ;
    }

    public long maxAlternatingSum(int[] nums, int[][] swaps) {
        int n = nums.length;
        parent = new int[n];
        IntStream.range(0, n).forEach(i -> parent[i] = i);
        for (int[] s : swaps) {
            union(s[0], s[1]);
        }

        Map<Integer, List<Integer>> components = IntStream.range(0, n)
                .boxed()
                .collect(Collectors.groupingBy(this::find));

        long totalMaxSum = 0;
        for (List<Integer> indices : components.values()) {
            List<Integer> values = indices.stream()
                    .map(i -> nums[i])
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());
            long evenSlots = indices.stream().filter(i -> i % 2 == 0).count();
            totalMaxSum += IntStream.range(0, values.size())
                    .mapToLong(i -> (i < evenSlots ? 1L : -1L) * values.get(i))
                    .sum();
        }
        return totalMaxSum;
    }
}