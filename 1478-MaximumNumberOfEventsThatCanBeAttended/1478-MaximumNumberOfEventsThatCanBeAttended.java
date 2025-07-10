// Last updated: 7/10/2025, 8:55:38 AM
class Solution {
    public int maxEvents(int[][] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));        
        int cnt = 0, x = 0,res = 0;      
        while (!pq.isEmpty() || x < arr.length) {
            if (pq.isEmpty()) {
                cnt = arr[x][0];
            }
            while (x < arr.length && arr[x][0] <= cnt) {
                pq.offer(arr[x][1]);
                x++;
            }
            pq.poll();
            res++; 
            cnt++;    
            while (!pq.isEmpty() && pq.peek() < cnt) {
                pq.poll();
            }
        }
        return res;
    }
}