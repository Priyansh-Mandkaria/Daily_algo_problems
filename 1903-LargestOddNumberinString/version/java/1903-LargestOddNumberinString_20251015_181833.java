// Last updated: 10/15/2025, 6:18:33 PM
class Solution {
    public String largestOddNumber(String num) {
        int i = 0;
        int ind = -1;
        for(i = num.length() - 1; i >= 0; i-- ){
            if((num.charAt(i) - '0') % 2 == 1){
                ind = i;
                break;
            }
        }
        if(ind == -1) return "";
        i = 0;
        while(i <= ind && num.charAt(i) == 0) i++;
        return num.substring(i,ind+1);
    }
}