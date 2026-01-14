// Last updated: 1/14/2026, 11:27:50 AM
1import java.util.*;
2
3class Solution {
4    // Helper class to represent active X-intervals
5    private static class Interval implements Comparable<Interval> {
6        int start, end;
7        
8        Interval(int start, int end) {
9            this.start = start;
10            this.end = end;
11        }
12        
13        // Needed for sort
14        public int compareTo(Interval other) {
15            if (this.start != other.start) return Integer.compare(this.start, other.start);
16            return Integer.compare(this.end, other.end);
17        }
18
19        // Needed for removing specific objects from ArrayList
20        public boolean equals(Object o) {
21            if (this == o) return true;
22            if (o == null || getClass() != o.getClass()) return false;
23            Interval interval = (Interval) o;
24            return start == interval.start && end == interval.end;
25        }
26    }
27
28    // Helper class for Sweep Line events
29    private static class Event implements Comparable<Event> {
30        int y;
31        int type; // 1 for start, -1 for end
32        int xStart, xEnd;
33
34        Event(int y, int type, int xStart, int xEnd) {
35            this.y = y;
36            this.type = type;
37            this.xStart = xStart;
38            this.xEnd = xEnd;
39        }
40
41        public int compareTo(Event other) {
42            return Integer.compare(this.y, other.y);
43        }
44    }
45
46    public double separateSquares(int[][] squares) {
47        List<Event> sweepEvents = new ArrayList<>();
48        for (int[] sq : squares) {
49            int x = sq[0];
50            int y = sq[1];
51            int l = sq[2];
52            sweepEvents.add(new Event(y, 1, x, x + l));
53            sweepEvents.add(new Event(y + l, -1, x, x + l));
54        }
55
56        Collections.sort(sweepEvents);
57
58        List<Interval> activeIntervals = new ArrayList<>();
59        // Store strips as: [y_bottom, height, union_width]
60        List<double[]> processedStrips = new ArrayList<>();
61        
62        double totalArea = 0;
63        int prevY = sweepEvents.get(0).y;
64
65        for (Event event : sweepEvents) {
66            // Process the gap (strip) between the previous event and this one
67            if (event.y > prevY) {
68                double unionWidth = getUnionWidth(activeIntervals);
69                double height = (double) event.y - prevY;
70                
71                if (unionWidth > 0) {
72                    processedStrips.add(new double[]{prevY, height, unionWidth});
73                    totalArea += height * unionWidth;
74                }
75            }
76
77            // Update active intervals list
78            Interval currentInterval = new Interval(event.xStart, event.xEnd);
79            if (event.type == 1) {
80                activeIntervals.add(currentInterval);
81            } else {
82                activeIntervals.remove(currentInterval);
83            }
84            
85            prevY = event.y;
86        }
87
88        // Second Pass: Find the split point
89        double targetArea = totalArea / 2.0;
90        double accumulatedArea = 0;
91
92        for (double[] strip : processedStrips) {
93            double bottomY = strip[0];
94            double height = strip[1];
95            double width = strip[2];
96            double stripArea = height * width;
97
98            if (accumulatedArea + stripArea >= targetArea) {
99                double missingArea = targetArea - accumulatedArea;
100                return bottomY + (missingArea / width);
101            }
102            accumulatedArea += stripArea;
103        }
104
105        return 0.0;
106    }
107
108    // Brute force union width calculation: O(K log K) where K is active squares
109    private double getUnionWidth(List<Interval> intervals) {
110        if (intervals.isEmpty()) return 0;
111
112        // Create a copy to sort, so we don't mess up the main list order unnecessarily
113        List<Interval> sorted = new ArrayList<>(intervals);
114        Collections.sort(sorted);
115
116        double unionLength = 0;
117        double currentEnd = -1e18; // Negative infinity
118
119        for (Interval iv : sorted) {
120            if (iv.start >= currentEnd) {
121                // Disjoint interval
122                unionLength += (iv.end - iv.start);
123                currentEnd = iv.end;
124            } else if (iv.end > currentEnd) {
125                // Overlapping interval
126                unionLength += (iv.end - currentEnd);
127                currentEnd = iv.end;
128            }
129        }
130        return unionLength;
131    }
132}