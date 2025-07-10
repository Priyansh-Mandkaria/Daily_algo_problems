// Last updated: 7/10/2025, 8:57:39 AM
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> priyansh = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                priyansh.add("FizzBuzz");
            } else if (i % 3 == 0) {
                priyansh.add("Fizz");
            } else if (i % 5 == 0) {
                priyansh.add("Buzz");
            } else {
                priyansh.add(Integer.toString(i));
            }
        }   
        return priyansh;
    }
}