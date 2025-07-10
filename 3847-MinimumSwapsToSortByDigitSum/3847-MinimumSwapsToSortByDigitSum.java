// Last updated: 7/10/2025, 8:49:24 AM
class Solution {
    public int minSwaps(int[] nums) {
    //     int n = nums.length;
        
    //     List<int[]> sorted = IntStream.range(0, n)
    //         .mapToObj(i -> new int[]{nums[i], i})
    //         .sorted(Comparator.<int[]>comparingInt(a -> digitSum(a[0]))
    //                 .thenComparingInt(a -> a[0]))
    //         .collect(Collectors.toList());

    //     Map<Integer, Integer> indexMap = IntStream.range(0, n)
    //         .boxed()
    //         .collect(Collectors.toMap(i -> sorted.get(i)[1], i -> i));

    //     boolean[] visited = new boolean[n];
    //     int swaps = 0;

    //     for (int i = 0; i < n; i++) {
    //         if (visited[i] || indexMap.get(i) == i) continue;
    //         int j = i, cycle = 0;
    //         while (!visited[j]) {
    //             visited[j] = true;
    //             j = indexMap.get(j);
    //             cycle++;
    //         }
    //         swaps += cycle - 1;
    //     }
    //     return swaps;
    // }

    // private int digitSum(int x) {
    //     return String.valueOf(x).chars().map(c -> c - '0').sum();
        int n = nums.length, swaps = 0;
        int[][] valIdx = new int[n][2];
        
        for (int i = 0; i < n; i++)
            valIdx[i] = new int[]{nums[i], i};

        Arrays.sort(valIdx, (a, b) -> {
            int sa = digitSum(a[0]), sb = digitSum(b[0]);
            return sa != sb ? sa - sb : a[0] - b[0];
        });

        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] || valIdx[i][1] == i) continue;
            int j = i, cycle = 0;
            while (!vis[j]) {
                vis[j] = true;
                j = valIdx[j][1];
                cycle++;
            }
            swaps += cycle - 1;
        }
        return swaps;
    }

    private int digitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}