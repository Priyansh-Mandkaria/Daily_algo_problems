// Last updated: 7/10/2025, 8:53:34 AM
class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE,sum=0;
        for(int i : differences){
            sum+=i;
            min=Math.min(sum,min);
            max=Math.max(sum,max);
        }
        int count=0;
        for(int i=lower;i<=upper;i++){
            if(i+min>=lower && i+max<=upper) count++;
        }
        return count;
    }
}