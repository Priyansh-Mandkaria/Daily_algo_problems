// Last updated: 6/22/2026, 1:35:17 PM
class Solution {
      private static final long M=1_000_000_007L;
      public int zigZagArrays(int n,int l,int r){
        int m=r-l+1; if(n==1) return (int)(m%M);
        if(m==1) return 0;
        if(n==2) return (int)((1L*m*(m-1))%M);
        int s=2*m; long[][] A=new long[s][s];
        IntStream.range(0,m).forEach(v->IntStream.range(0,m).forEach(u->{ if(u<v) A[v][m+u]=1; if(u>v) A[m+v][u]=1; }));
        long[] x=new long[s];
        IntStream.range(0,m).forEach(j->{ x[j]=j; x[m+j]=m-1-j; });
        long[][] P=pow(A,n-2);
        long[] y=vmul(x,P);
        long ans=LongStream.of(y).reduce(0L,(a,b)->(a+b)%M);
        return (int)ans;
      }
      private long[] vmul(long[] v,long[][] B){
        int n=v.length; long[] r=new long[n];
        IntStream.range(0,n).forEach(i->{ long vi=v[i]; if(vi!=0)
          IntStream.range(0,n).forEach(j->{ long bj=B[i][j]; if(bj!=0) r[j]=(r[j]+vi*bj)%M; });
        });
        return r;
      }
      private long[][] pow(long[][] a,long e){
        int n=a.length;
        long[][] r=IntStream.range(0,n)
          .mapToObj(i->{ long[] row=new long[n]; row[i]=1; return row; })
          .toArray(long[][]::new);
        long[][] c=cpy(a);
        while(e>0){ if((e&1L)==1L) r=mul(r,c); c=mul(c,c); e>>=1; }
        return r;
      }
      private long[][] mul(long[][] A,long[][] B){
        int n=A.length; long[][] C=new long[n][n];
        IntStream.range(0,n).forEach(i->
          IntStream.range(0,n).forEach(k->{ long ak=A[i][k]; if(ak!=0)
            IntStream.range(0,n).forEach(j->{ long bk=B[k][j]; if(bk!=0) C[i][j]=(C[i][j]+ak*bk)%M; });
          })
        );
        return C;
      }
      private long[][] cpy(long[][] A){
        int n=A.length; long[][] B=new long[n][n];
        IntStream.range(0,n).forEach(i->System.arraycopy(A[i],0,B[i],0,n));
        return B;
      }
      private int zz(int...x){ return Arrays.hashCode(x)^17; }

}