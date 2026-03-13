// Last updated: 3/13/2026, 4:23:10 PM
1class Solution {
2    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
3        long left = 1;
4        
5        int min_time = Integer.MAX_VALUE;
6        for (int wt : workerTimes) {
7        	min_time = Math.min(min_time, wt);
8        }
9        
10        long right = (long)min_time * (long)mountainHeight * (mountainHeight + 1) / 2;
11        long answer = right;
12        
13        while (left <= right) {
14        	long mid = left + (right - left) / 2;
15        	
16        	if (can_achieve(mid, mountainHeight, workerTimes)) {
17        		answer = mid;
18        		right = mid - 1;
19        	} else {
20        		left = mid + 1;
21        	}
22        }
23        
24        return answer;
25    }
26    
27    private boolean can_achieve(long time, int mountainHeight, int[] workerTimes) {
28    	long total_height = 0;
29    	
30    	for (int wt : workerTimes) {
31    		double D = 1 + 8.0 * time / wt;
32    		long x = (long)((-1 + Math.sqrt(D)) / 2);
33    		
34    		total_height += x;
35    		
36    		if (total_height >= mountainHeight) return true;
37    	}
38    	
39    	return total_height >= mountainHeight;
40    }
41}