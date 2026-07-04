// Last updated: 7/4/2026, 6:51:43 AM
1class Solution {
2    public int minScore(int n, int[][] roads) {  
3        Arrays.sort(roads, (a, b)->{
4            return a[0] - b[0];
5        });
6        HashSet<Integer> set = new HashSet<>();
7        set.add(roads[0][0]);
8        set.add(roads[0][1]);
9        int min = roads[0][2];
10        for(int j = 0; j < 100; j++){
11            for(int i = 1; i < roads.length; i++){
12                if(set.contains(roads[i][0]) || set.contains(roads[i][1])){
13                    min = Math.min(roads[i][2], min);
14                    set.add(roads[i][0]);
15                    set.add(roads[i][1]);
16                }
17            }
18        }        
19        return min;
20    }
21}