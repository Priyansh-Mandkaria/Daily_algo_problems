// Last updated: 10/5/2025, 8:09:30 AM
class Solution {
    public String removeSubstring(String s, int k) {
        final Deque<int[]> d=new ArrayDeque<>();
    s.chars().forEach(ch->{
      if(d.isEmpty()||d.peekLast()[0]!=ch) d.addLast(new int[]{ch,1});
      else d.peekLast()[1]++;
      boolean g=true;
      while(g&&d.size()>=2){
        int[] b=d.pollLast(); int[] a=d.peekLast();
        if(a!=null&&a[0]=='('&&b[0]==')'&&a[1]>=k&&b[1]>=k){
          a[1]-=k; b[1]-=k;
          if(b[1]>0) d.addLast(b);
          if(a[1]==0) d.pollLast();
        }else{ d.addLast(b); g=false; }
      }
    });
    return d.stream().map(p->String.valueOf((char)p[0]).repeat(p[1])).collect(Collectors.joining());
    }
}