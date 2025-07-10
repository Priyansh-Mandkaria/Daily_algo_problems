// Last updated: 7/10/2025, 8:56:06 AM
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<String,Integer>s=new HashMap<>();
        int ans=0;
        for(int a[]:dominoes){
String x=String.valueOf(a[0])+String.valueOf(a[1]);
String y=String.valueOf(a[1])+String.valueOf(a[0]);
    ans+=s.getOrDefault(x,0);
if(!x.equals(y)){
    ans+=s.getOrDefault(y,0);
}
s.put(x,s.getOrDefault(x,0)+1);

        }
        return ans;
    }
}