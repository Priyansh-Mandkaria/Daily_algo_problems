// Last updated: 7/10/2025, 8:50:40 AM
class Solution {
    public int generateKey(int num1, int num2, int num3) {
        StringBuilder key = new StringBuilder();
        String new_num1 = String.format("%04d", num1);
        String new_num2 = String.format("%04d", num2);
        String new_num3 = String.format("%04d", num3);
        for (int i = 0; i < 4; i++) {
            char new_final = (char) Math.min(new_num1.charAt(i), Math.min(new_num2.charAt(i), new_num3.charAt(i)));
            key.append(new_final);
        }
        return Integer.parseInt(key.toString());
    }
}