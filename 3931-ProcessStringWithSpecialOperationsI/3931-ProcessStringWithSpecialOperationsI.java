// Last updated: 7/13/2025, 12:58:33 PM
class Solution {
    public String processStr(String s) {
        StringBuilder ans = new StringBuilder();
        for(char x : s.toCharArray()){
            if(x == '*'){
                if(ans.length()>0)ans.setLength(ans.length()-1);
            }
            else if(x == '#')ans.append(ans);
            else if(x == '%')ans.reverse();
            else ans.append(x);
        }    
        return ans.toString();
    }
}