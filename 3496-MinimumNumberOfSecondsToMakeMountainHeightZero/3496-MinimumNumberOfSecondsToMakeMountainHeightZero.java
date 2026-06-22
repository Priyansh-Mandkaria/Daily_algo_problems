// Last updated: 6/22/2026, 1:38:16 PM
class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 1;
        
        int min_time = Integer.MAX_VALUE;
        for (int wt : workerTimes) {
        	min_time = Math.min(min_time, wt);
        }
        
        long right = (long)min_time * (long)mountainHeight * (mountainHeight + 1) / 2;
        long answer = right;
        
        while (left <= right) {
        	long mid = left + (right - left) / 2;
        	
        	if (can_achieve(mid, mountainHeight, workerTimes)) {
        		answer = mid;
        		right = mid - 1;
        	} else {
        		left = mid + 1;
        	}
        }
        
        return answer;
    }
    
    private boolean can_achieve(long time, int mountainHeight, int[] workerTimes) {
    	long total_height = 0;
    	
    	for (int wt : workerTimes) {
    		double D = 1 + 8.0 * time / wt;
    		long x = (long)((-1 + Math.sqrt(D)) / 2);
    		
    		total_height += x;
    		
    		if (total_height >= mountainHeight) return true;
    	}
    	
    	return total_height >= mountainHeight;
    }
}