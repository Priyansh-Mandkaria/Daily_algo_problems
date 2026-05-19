// Last updated: 5/19/2026, 11:43:36 AM
1class Solution {
2    public int minJumps(int[] arr) {
3        Map<Integer, List<Integer>> map=new HashMap<>();
4        int n=arr.length;
5        int[]visited=new int[n];
6        for(int i=0;i<n;i++){
7            if(map.containsKey(arr[i])){
8                map.get(arr[i]).add(i);
9            }else map.put(arr[i],new ArrayList<>(List.of(i)));
10        }
11        int ans=0;
12        Queue<Integer>queue=new LinkedList<>();
13        queue.offer(0);
14        visited[0]=1;
15        while(!queue.isEmpty()){
16            int size=queue.size();
17            for(int i=0;i<size;i++){
18                int cur=queue.poll();
19                if(cur==n-1)return ans;
20                if(cur-1>=0&&visited[cur-1]==0){
21                    visited[cur-1]=1;
22                    queue.offer(cur-1);
23                }
24                if(cur+1<=n-1&&visited[cur+1]==0){
25                    visited[cur+1]=1;
26                    queue.offer(cur+1);
27                }
28                if(map.containsKey(arr[cur])){
29                    for(int val:map.get(arr[cur])){
30                       if(visited[val]==0){
31                           queue.offer(val);
32                           visited[val]=1;
33                       }
34                    }
35                    map.remove(arr[cur]);
36                }
37            }
38            ans++;
39        }
40        return -1;
41
42    }
43}