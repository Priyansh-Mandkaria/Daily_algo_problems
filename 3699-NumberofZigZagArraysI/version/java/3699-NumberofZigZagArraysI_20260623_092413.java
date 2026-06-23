// Last updated: 6/23/2026, 9:24:13 AM
1class Solution {
2    public int zigZagArrays(int n, int l, int r) {
3        int m=r-l+1; long M=1_000_000_007L;
4        if(n==1) return (int)(m%M);
5        long[] u=IntStream.range(0,m).mapToLong(i->i).toArray();
6        long[] d=IntStream.range(0,m).mapToLong(i->m-1-i).toArray();
7        for(int t=3;t<=n;t++){
8          long[] pr=new long[m], sf=new long[m]; AtomicLong s=new AtomicLong();
9          final long[] D=d, U=u;
10          IntStream.range(0,m).forEach(i->pr[i]=(s.addAndGet(D[i]))%M);
11          s.set(0);
12          IntStream.iterate(m-1,i->i>=0,i->i-1).forEach(i->sf[i]=(s.addAndGet(U[i]))%M);
13          long[] nu=IntStream.range(0,m).mapToLong(z->z>0?pr[z-1]:0).toArray();
14          long[] nd=IntStream.range(0,m).mapToLong(z->z+1<m?sf[z+1]:0).toArray();
15          u=nu; d=nd;
16        }
17        long a=(LongStream.of(u).reduce(0L,(x,y)->(x+y)%M)+LongStream.of(d).reduce(0L,(x,y)->(x+y)%M))%M;
18        return (int)a;
19  }
20  private int xx(int...x){ return Arrays.hashCode(x)^7; }
21}