// Last updated: 12/23/2025, 2:56:29 PM
1import java.util.*;
2class Solution {
3    public int maxTwoEvents(int[][] events) {
4        int n = events.length;
5        Arrays.sort(events, (a, b) -> a[0] - b[0]);
6        int[] suffixMax = new int[n];
7        suffixMax[n - 1] = events[n - 1][2]; 
8        for (int i = n - 2; i >= 0; --i) {
9            suffixMax[i] = Math.max(events[i][2], suffixMax[i + 1]);
10        }
11        int maxSum = 0;
12        for (int i = 0; i < n; ++i) {
13            int left = i + 1, right = n - 1;
14            int nextEventIndex = -1;
15            while (left <= right) {
16                int mid = left + (right - left) / 2;
17                if (events[mid][0] > events[i][1]) {
18                    nextEventIndex = mid;
19                    right = mid - 1;
20                } else {
21                    left = mid + 1;
22                }
23            }
24            if (nextEventIndex != -1) {
25                maxSum = Math.max(maxSum, events[i][2] + suffixMax[nextEventIndex]);
26            }
27            maxSum = Math.max(maxSum, events[i][2]);
28        }  
29        return maxSum;
30    }
31}