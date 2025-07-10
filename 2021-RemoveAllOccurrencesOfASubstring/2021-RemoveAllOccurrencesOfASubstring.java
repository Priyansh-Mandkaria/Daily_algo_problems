// Last updated: 7/10/2025, 8:54:14 AM
class Solution {
    public String removeOccurrences(String s, String part) {
        while(s.contains(part)){
            s = s.replaceFirst(part,"");
        }
        return s;
    }
}