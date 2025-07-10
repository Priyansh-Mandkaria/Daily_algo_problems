// Last updated: 7/10/2025, 8:54:01 AM
class Solution {
    public String reversePrefix(String word, char ch) {
        int x = word.indexOf(ch);
        if (x == -1) {
            return word;
        }
        char[] charArray = word.toCharArray();
        int left = 0, right = x;
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        return new String(charArray);
    }
}
