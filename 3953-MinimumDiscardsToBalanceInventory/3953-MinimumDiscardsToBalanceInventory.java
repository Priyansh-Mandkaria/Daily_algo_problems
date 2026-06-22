// Last updated: 6/22/2026, 1:35:24 PM
class Solution {
    public int minArrivalsToDiscard(int[] a, int w, int m) {
        Deque<int[]> q=new ArrayDeque<>();
        Map<Integer,Integer> f=new HashMap<>();
        return (int)IntStream.rangeClosed(1,a.length).map(i->{int t=a[i-1],lb=i-w+1;while(!q.isEmpty()&&q.peek()[0]<lb){int[]x=q.poll();f.merge(x[1],-1,Integer::sum);if(f.get(x[1])==0)f.remove(x[1]);}if(f.getOrDefault(t,0)>=m)return 1;q.add(new int[]{i,t});f.merge(t,1,Integer::sum);return 0;}).sum();
    }
}