// Last updated: 6/22/2026, 1:37:25 PM
import java.util.*;

class Solution {

    // Step 1: Sieve of Eratosthenes to find all primes up to a given number
    private void findPrime(boolean[] isPrime, int n) {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false; // 0 and 1 are not prime numbers
        
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false; // Mark all multiples of i as non-prime
                }
            }
        }
    }

    // Step 2: Generate possible "neighboring nodes" by increasing or decreasing digits
    private List<Integer> findNode(int n) {
        List<Integer> neighbors = new ArrayList<>();
        
        for (int i = 1; i <= n; i *= 10) {
            int d = (n / i) % 10; // Extract the current digit
            
            // Decrease the current digit if possible
            if (d > 0) {
                neighbors.add(n - i);
            }

            // Increase the current digit if possible
            if (d < 9) {
                neighbors.add(n + i);
            }
        }

        return neighbors;
    }

    // Step 3: Main function to find the minimum operations
    public int minOperations(int n, int m) {
        final int MAX = 10000; // Limit for prime computation
        final int INF = Integer.MAX_VALUE; // Represent unreachable distances
        
        // Step 3.1: Precompute all primes up to MAX
        boolean[] isPrime = new boolean[MAX];
        findPrime(isPrime, MAX);
        
        // Edge case: If starting or ending node is prime, return -1
        if (isPrime[n] || isPrime[m]) {
            return -1;
        }

        // Step 3.2: Initialize distance array and priority queue
        int[] dist = new int[MAX];
        Arrays.fill(dist, INF);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Start from node `n`
        dist[n] = 0;
        pq.add(new int[]{dist[n], n});

        // Step 3.3: Dijkstra's algorithm to find shortest path
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int dis = current[0]; // Current distance
            int num = current[1]; // Current node

            // Skip processing if the node is prime
            if (isPrime[num]) {
                continue;
            }

            // Explore all neighboring nodes
            for (int neighbor : findNode(num)) {
                // Skip processing if the neighbor is prime
                if (isPrime[neighbor]) {
                    continue;
                }

                // Relax the distance for the neighbor
                if (dist[neighbor] > dis + num) {
                    dist[neighbor] = dis + num;
                    pq.add(new int[]{dist[neighbor], neighbor});
                }
            }
        }

        // Step 3.4: Return the result
        return dist[m] == INF ? -1 : m + dist[m];
    }
}