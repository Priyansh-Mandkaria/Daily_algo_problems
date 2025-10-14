// Last updated: 10/14/2025, 11:19:18 PM
class Solution {
    public String restoreString(String s, int[] indices) {
        // in this question we have to shuffle our string
        // according to given indices.
        // in the ascending order.
        char[] arr = new char[s.length()];
        for(int i = 0 ; i < s.length(); i++){
            arr[indices[i]] = s.charAt(i);
        }
        return new String(arr);
    }
}