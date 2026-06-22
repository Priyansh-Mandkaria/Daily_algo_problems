// Last updated: 6/22/2026, 1:35:34 PM
class Solution {
    public long popcountDepth(long n, int k) {
        if(k==0){
            return(n>=1)?1:0;
        }
        int[] j=new int[64];
        Arrays.fill(j,-1);
        Set<Integer> l=new HashSet<>();
        for(int m=1;m<64;m++){
            if(depth(m,j)==k-1){
                l.add(m);
            }
        }
        if(l.isEmpty()){
            return 0;
        }
        String s=Long.toBinaryString(n);
        int o=s.length();
        long[][][] i=new long[o+1][o+2][2];
        for(long[][] p:i){
            for(long[] q:p){
                Arrays.fill(q,-1);
            }
        }
        long r = solution(0,0,false,s,l,i);
        if(k==1){
            return r-1;
        }
        return r;
    }
    
    private int depth(int n, int[] j){
        if(n==1){
            return 0;
        }
        if(j[n]!=-1){
            return j[n];
        }
        int m=Integer.bitCount(n);
        return j[n]=1+depth(m,j);
    }

    private long solution(int a, int b, boolean c, String s, Set<Integer> l, long[][][] i) {
        if(a==s.length()){
            return l.contains(b)?1L:0L;
        }
        int d=c?1:0;
        if(i[a][b][d]!=-1){
            return i[a][b][d];
        }
        long e=0;
        int f=c?1:(s.charAt(a)-'0');
        for(int g=0;g<=f;g++){
            boolean h=c||(g<f);
            e+=solution(a+1,b+g,h,s,l,i);
        }
        return i[a][b][d]=e;
    }
}