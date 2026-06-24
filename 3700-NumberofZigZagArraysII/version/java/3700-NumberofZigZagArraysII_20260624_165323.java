// Last updated: 6/24/2026, 4:53:23 PM
1class Solution {
2      private static final long M=1_000_000_007L;
3      public int zigZagArrays(int n,int l,int r){
4        int m=r-l+1; if(n==1) return (int)(m%M);
5        if(m==1) return 0;
6        if(n==2) return (int)((1L*m*(m-1))%M);
7        int s=2*m; long[][] A=new long[s][s];
8        IntStream.range(0,m).forEach(v->IntStream.range(0,m).forEach(u->{ if(u<v) A[v][m+u]=1; if(u>v) A[m+v][u]=1; }));
9        long[] x=new long[s];
10        IntStream.range(0,m).forEach(j->{ x[j]=j; x[m+j]=m-1-j; });
11        long[][] P=pow(A,n-2);
12        long[] y=vmul(x,P);
13        long ans=LongStream.of(y).reduce(0L,(a,b)->(a+b)%M);
14        return (int)ans;
15      }
16      private long[] vmul(long[] v,long[][] B){
17        int n=v.length; long[] r=new long[n];
18        IntStream.range(0,n).forEach(i->{ long vi=v[i]; if(vi!=0)
19          IntStream.range(0,n).forEach(j->{ long bj=B[i][j]; if(bj!=0) r[j]=(r[j]+vi*bj)%M; });
20        });
21        return r;
22      }
23      private long[][] pow(long[][] a,long e){
24        int n=a.length;
25        long[][] r=IntStream.range(0,n)
26          .mapToObj(i->{ long[] row=new long[n]; row[i]=1; return row; })
27          .toArray(long[][]::new);
28        long[][] c=cpy(a);
29        while(e>0){ if((e&1L)==1L) r=mul(r,c); c=mul(c,c); e>>=1; }
30        return r;
31      }
32      private long[][] mul(long[][] A,long[][] B){
33        int n=A.length; long[][] C=new long[n][n];
34        IntStream.range(0,n).forEach(i->
35          IntStream.range(0,n).forEach(k->{ long ak=A[i][k]; if(ak!=0)
36            IntStream.range(0,n).forEach(j->{ long bk=B[k][j]; if(bk!=0) C[i][j]=(C[i][j]+ak*bk)%M; });
37          })
38        );
39        return C;
40      }
41      private long[][] cpy(long[][] A){
42        int n=A.length; long[][] B=new long[n][n];
43        IntStream.range(0,n).forEach(i->System.arraycopy(A[i],0,B[i],0,n));
44        return B;
45      }
46      private int zz(int...x){ return Arrays.hashCode(x)^17; }
47
48}