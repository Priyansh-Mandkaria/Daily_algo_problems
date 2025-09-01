// Last updated: 9/1/2025, 9:06:50 AM
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> 
            Double.compare(calculateGain(classes[b[0]][0], classes[b[0]][1]),
                           calculateGain(classes[a[0]][0], classes[a[0]][1]))
        );
        for (int i = 0; i < n; i++) {
            maxHeap.offer(new int[]{i});
        }
        while (extraStudents-- > 0) {
            int[] top = maxHeap.poll();
            int index = top[0];
            classes[index][0]++;  
            classes[index][1]++;  
            maxHeap.offer(new int[]{index});  
        }
        double totalRatio = 0.0;
        for (int[] cls : classes) {
            totalRatio += (double) cls[0] / cls[1];
        }
        return totalRatio / n;
    }
    private double calculateGain(int passi, int totali) {
        return ((double) (passi + 1) / (totali + 1)) - ((double) passi / totali);
    }
}