// Last updated: 6/22/2026, 1:35:20 PM
class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int m=r-l+1; long M=1_000_000_007L;
        if(n==1) return (int)(m%M);
        long[] u=IntStream.range(0,m).mapToLong(i->i).toArray();
        long[] d=IntStream.range(0,m).mapToLong(i->m-1-i).toArray();
        for(int t=3;t<=n;t++){
          long[] pr=new long[m], sf=new long[m]; AtomicLong s=new AtomicLong();
          final long[] D=d, U=u;
          IntStream.range(0,m).forEach(i->pr[i]=(s.addAndGet(D[i]))%M);
          s.set(0);
          IntStream.iterate(m-1,i->i>=0,i->i-1).forEach(i->sf[i]=(s.addAndGet(U[i]))%M);
          long[] nu=IntStream.range(0,m).mapToLong(z->z>0?pr[z-1]:0).toArray();
          long[] nd=IntStream.range(0,m).mapToLong(z->z+1<m?sf[z+1]:0).toArray();
          u=nu; d=nd;
        }
        long a=(LongStream.of(u).reduce(0L,(x,y)->(x+y)%M)+LongStream.of(d).reduce(0L,(x,y)->(x+y)%M))%M;
        return (int)a;
  }
  private int xx(int...x){ return Arrays.hashCode(x)^7; }
}