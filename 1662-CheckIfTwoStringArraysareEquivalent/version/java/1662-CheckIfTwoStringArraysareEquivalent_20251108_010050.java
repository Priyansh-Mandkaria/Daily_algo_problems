// Last updated: 11/8/2025, 1:00:50 AM
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        if(String.join("",word1).equals(String.join("",word2))) return true;
        return false;
    }
}