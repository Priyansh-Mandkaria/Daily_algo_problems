// Last updated: 10/15/2025, 3:45:29 PM
class Solution {
    public String removeOuterParentheses(String s) {
        int cnt = 0;
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) == '('){
                if(cnt > 0) res.append(s.charAt(i));
                cnt++;
            }
            else {
                cnt--;
                if(cnt > 0) res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}