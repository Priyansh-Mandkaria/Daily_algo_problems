// Last updated: 11/16/2025, 3:02:09 PM
class Solution {
    public String reverseWords(String s) {
        String arr[] = s.split(" ");
        String ans = "";
        for(int i = 0; i < arr.length; i++){
            StringBuilder str=new StringBuilder(arr[i]);
            ans += str.reverse().toString();
            if(i + 1 < arr.length){
                ans += " ";
            }
        }
    return ans;
    }
}