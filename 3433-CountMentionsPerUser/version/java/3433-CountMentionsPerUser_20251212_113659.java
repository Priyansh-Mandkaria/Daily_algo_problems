// Last updated: 12/12/2025, 11:36:59 AM
1class Solution {
2    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
3        int[] mentions = new int[numberOfUsers];
4        int[] offlineTime = new int[numberOfUsers];
5
6        events.sort((a, b) -> {
7            int timeA = Integer.parseInt(a.get(1));
8            int timeB = Integer.parseInt(b.get(1));
9            return timeA == timeB ? b.get(0).compareTo(a.get(0)) : timeA - timeB;
10        });
11
12        for (List<String> event : events) {
13            if (event.get(0).equals("MESSAGE")) {
14                handleMessage(event, mentions, offlineTime);
15            } else if (event.get(0).equals("OFFLINE")) {
16                handleOffline(event, offlineTime);
17            }
18        }
19
20        return mentions;
21    }
22
23    private void handleMessage(List<String> event, int[] mentions, int[] offlineTime) {
24        int timestamp = Integer.parseInt(event.get(1));
25        String[] tokens = event.get(2).split(" ");
26
27        for (String token : tokens) {
28            if (token.equals("ALL")) {
29                for (int i = 0; i < mentions.length; i++) mentions[i]++;
30            } else if (token.equals("HERE")) {
31                for (int i = 0; i < mentions.length; i++) {
32                    if (offlineTime[i] == 0 || offlineTime[i] + 60 <= timestamp) mentions[i]++;
33                }
34            } else {
35                int id = Integer.parseInt(token.substring(2));
36                mentions[id]++;
37            }
38        }
39    }
40
41    private void handleOffline(List<String> event, int[] offlineTime) {
42        int timestamp = Integer.parseInt(event.get(1));
43        int id = Integer.parseInt(event.get(2));
44        offlineTime[id] = timestamp;
45    }
46}