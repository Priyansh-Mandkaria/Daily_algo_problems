// Last updated: 6/22/2026, 1:34:51 PM
class Solution {
    public int getLeastFrequentDigit(int n) {
        int[] x = new int[10];
        int a = n;
        while(a > 0){
            int d = a % 10 ;
            x[d]++;
            a = a / 10;
        }
        int min = Integer.MAX_VALUE;
        int m = -1;
        for(int i = 0 ; i < 10 ; i++){
            if(x[i] > 0 && x[i] < min){
                min = x[i];
                m = i;
            }
        }
        return m;
    }
}