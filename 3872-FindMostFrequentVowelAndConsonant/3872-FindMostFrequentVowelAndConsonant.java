// Last updated: 7/10/2025, 8:49:15 AM
class Solution{
    public int maxFreqSum(String s){
        int[] c=new int[26];for(char ch:s.toCharArray())c[ch-'a']++;
        return Collections.max(Arrays.asList(c[0],c[4],c[8],c[14],c[20]))
             +Collections.max(IntStream.range(0,26).filter(i->"aeiou".indexOf((char)(i+'a'))<0).map(i->c[i]).boxed().collect(Collectors.toList()));
    }
}
