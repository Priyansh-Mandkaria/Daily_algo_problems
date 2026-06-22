// Last updated: 6/22/2026, 1:35:37 PM
class Solution {
    static final int n = 1000005;
    static boolean[] isPrime = new boolean[n];

    static {
        isPrime[0] = isPrime[1] = true;

        for (int i = 2; i <= 1000; i++)
            if (!isPrime[i])
                for (int j = i * i; j < n; j += i)
                    isPrime[j] = true;
    }

    public int minJumps(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        
        for (int i = 1; i < len; i++)
            max = Math.max(max, nums[i]);

        int[] head = new int[max + 1];
        Arrays.fill(head, -1);
        int[] next = new int[len];

        for (int i = 0; i < len; i++) {
            next[i] = head[nums[i]];
            head[nums[i]] = i;
        }

        int[] dp = new int[len];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        Set<Integer> seen = new HashSet<>();

        while (!queue.isEmpty()) {
            int dq = queue.poll();

            if (dq == len - 1)
                return dp[dq];

            int right = dq + 1;
            if (right < len && dp[right] == -1) {
                dp[right] = dp[dq] + 1;
                queue.add(right);
            }

            int left = dq - 1;
            if (left >= 0 && dp[left] == -1) {
                dp[left] = dp[dq] + 1;
                queue.add(left);
            }

            int val = nums[dq];
            if (!isPrime[val] && !seen.contains(val)) {
                seen.add(val);
                for (int i = val; i <= max; i += val) {
                    for (int j = head[i]; j != -1; j = next[j]) {
                        if (dp[j] == -1) {
                            dp[j] = dp[dq] + 1;
                            queue.add(j);
                        }
                    }
                    head[i] = -1;
                }
            }
        }

        return -1;
    }
}