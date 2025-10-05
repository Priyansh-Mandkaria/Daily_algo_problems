// Last updated: 10/5/2025, 8:21:19 AM
class Solution {
    public long countNoZeroPairs(long n) {
        int[] ds=new StringBuilder(""+n).reverse().chars().map(c->c-'0').toArray();
    long[][][] f=new long[2][2][2]; f[0][0][0]=1; 
    for(int d:ds){
      long[][][] g=new long[2][2][2];
      for(int c=0;c<2;c++)for(int ea=0;ea<2;ea++)for(int eb=0;eb<2;eb++){
        long w=f[c][ea][eb]; if(w==0) continue;
        if(ea==1&&eb==1){ int s=c; if(s%10==d) g[s/10][1][1]+=w; continue; }
        if(ea==1){ for(int b=1;b<=9;b++){ int s=b+c; if(s%10==d){ g[s/10][1][0]+=w; g[s/10][1][1]+=w; } } continue; }
        if(eb==1){ for(int a=1;a<=9;a++){ int s=a+c; if(s%10==d){ g[s/10][0][1]+=w; g[s/10][1][1]+=w; } } continue; }
        for(int a=1;a<=9;a++)for(int b=1;b<=9;b++){
          int s=a+b+c; if(s%10==d){
            g[s/10][0][0]+=w; g[s/10][1][0]+=w; g[s/10][0][1]+=w; g[s/10][1][1]+=w;
          }
        }
      }
      f=g;
    }
    return f[0][1][1];
    }
}