// Last updated: 7/10/2025, 8:59:05 AM
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        ArrayList<Integer> list = new ArrayList<>();
        int carry = 1; 
        for (int i = n - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            if (sum >= 10) {
                list.add(0);
            } else {
                list.add(sum);
                carry = 0;
            }
        }
        if (carry == 1) {
            list.add(1);
        }
        Collections.reverse(list);
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
