// Last updated: 11/8/2025, 3:31:11 PM
class Solution {
    public boolean halvesAreAlike(String s) {
        if(s.length() % 2 != 0) return false;
        s = s.toLowerCase();
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i = 0; i < s.length()/2 ; i++){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                cnt1++;
            }
        }
        for(int i = s.length()/2; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                cnt2++;
            }
        }
        if(cnt1 == cnt2) return true;
        return false;
    }
}