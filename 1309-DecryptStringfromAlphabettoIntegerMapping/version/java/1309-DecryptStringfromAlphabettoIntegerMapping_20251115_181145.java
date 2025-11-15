// Last updated: 11/15/2025, 6:11:45 PM
class Solution {
    public String freqAlphabets(String s) {
        Map<Integer,Character> mp = new HashMap<>();
        for(char i = 'a'; i <= 'z'; i++){
            mp.put(i - 'a' + 1, i);
        }
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while(i >= 0){
            if(s.charAt(i) == '#'){
                String sub = s.substring(i-2,i);
                int num = Integer.parseInt(sub);
                sb.append(mp.get(num));
                i = i -3;
            }
            else{
                char sub = s.charAt(i);
                int num = Character.getNumericValue(sub);
                sb.append(mp.get(num));
                i = i - 1;
            }
        }
        return sb.reverse().toString();
    }
}