// Last updated: 7/10/2025, 8:49:04 AM
class Solution {
    public int minStable(int[] arr, int maxC) {
        if(arr.length == 0)return 0;
        int[] l_tab = new int[arr.length + 1];
        int max = 31 - Integer.numberOfLeadingZeros(arr.length);
        int [][] arr2 = new int[arr.length][max + 1];
        for(int i = 0; i < arr.length; i++) arr2[i][0] = arr[i];
        for(int i = 2; i <=arr.length ; i++) l_tab[i] = l_tab[i/2] + 1;
        for(int i = 1; i <= max ; i++){
            for(int j =0; j + (1 << i) <= arr.length; j++) arr2[j][i] = g(arr2[j][i-1],arr2[j + (1 <<(i-1))][i-1]);
        }
        int low = 0, high = arr.length,fi = arr.length;
        while(low <= high){
            int x = low + (high - low)/2;
            if(x + 1 > arr.length){
                fi = x;
                high = x - 1;
                continue;
            }
            int cnt = 0;
            int i = 0;
            while( i <= arr.length - x - 1){
                int j = l_tab[x+1];
                int range = g(arr2[i][j],arr2[i + x + 1 - (1 << j)][j]);
                if(range >= 2){
                    cnt++;
                    i += x + 1;
                }
                else i++ ;
            }
            if(cnt <= maxC){// maxC is given already !
                fi = x;
                high = x - 1;
            }
            else low = x + 1; 
        }
        return fi;
    }
    // from my personal template of gcd
    private int g(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}