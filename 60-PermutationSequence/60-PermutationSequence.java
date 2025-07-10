// Last updated: 7/10/2025, 8:59:06 AM
class Solution {
    public String getPermutation(int n, int k) {
         List<Integer> numbers = new ArrayList<>();
        int fact = 1; 
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            fact *= i; 
        }
        k--; 
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            fact /= (n - i); 
            int index = k / fact; 
            result.append(numbers.get(index)); 
            numbers.remove(index); 
            k %= fact; 
        }
        return result.toString();
    }
}