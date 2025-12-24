// Last updated: 12/25/2025, 12:08:56 AM
1class Solution {
2    public String frequencySort(String s) {
3        Map<Character,Integer> mp = new HashMap<>();
4        for(char c : s.toCharArray()){
5            mp.put(c,mp.getOrDefault(c,0)+1);
6        }
7        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> mp.get(b)-mp.get(a));
8        maxHeap.addAll(mp.keySet());
9        StringBuilder result = new StringBuilder();
10        while(!maxHeap.isEmpty()){
11            char c = maxHeap.poll();
12            int freq = mp.get(c);
13            for(int i = 0; i < freq; i++){
14                result.append(c);
15            }
16        }
17        return result.toString();
18    }
19};