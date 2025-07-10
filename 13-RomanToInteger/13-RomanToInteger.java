// Last updated: 7/10/2025, 8:59:54 AM
class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int current = valueOfRoman(s.charAt(i));
            int next = (i + 1 < n) ? valueOfRoman(s.charAt(i + 1)) : 0;

            if (current < next) {
                sum -= current;
            } else {
                sum += current;
            }
        }

        return sum;
    }

    private int valueOfRoman(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}
