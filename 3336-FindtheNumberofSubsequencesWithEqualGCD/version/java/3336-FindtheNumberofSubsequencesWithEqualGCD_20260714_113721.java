// Last updated: 7/14/2026, 11:37:21 AM
1class Solution {
2    int mod;
3    public int subsequencePairCount(int[] arr) {
4        mod=1000000007;
5        int n=arr.length;
6        int max=-1; 
7        for(int ele:arr){
8            max=Math.max(max,ele);
9        }
10        Integer [][][] dp=new Integer[n][max+1][max+1];
11        return check(dp,0,0,0,arr);
12    }
13    public int check(Integer [][][] dp,int i,int gcda,int gcdb,int [] arr){
14        if(i==arr.length){
15            return (gcda != 0 && gcdb != 0 && gcda == gcdb)?1:0;
16        }
17        if(dp[i][gcda][gcdb]!=null)return dp[i][gcda][gcdb];
18        int takeA=check(dp,i+1,gcd(gcda,arr[i]),gcdb,arr);
19        int takeB=check(dp,i+1,gcda,gcd(gcdb,arr[i]),arr);
20        int notTake=check(dp,i+1,gcda,gcdb,arr);
21    return dp[i][gcda][gcdb]=(int)((1L*takeA+takeB+notTake)%mod);
22    }
23    public int gcd(int a,int b){
24       while(b!=0){
25          int temp=b;
26          b=a%b;
27          a=temp;
28       }   
29    return a;}
30}