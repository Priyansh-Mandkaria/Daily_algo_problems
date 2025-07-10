// Last updated: 7/10/2025, 8:59:31 AM
class Solution {
    public String countAndSay(int n) {
        // this one is recursive approch more time complexity
        // if (n == 1) return "1";

        // String prev = countAndSay(n - 1);
        // StringBuilder result = new StringBuilder();

        // int count = 1;
        // for (int i = 1; i < prev.length(); i++) {
        //     if (prev.charAt(i) == prev.charAt(i - 1)) {
        //         count++;
        //     } else {
        //         result.append(count).append(prev.charAt(i - 1));
        //         count = 1;
        //     }
        // }
        // result.append(count).append(prev.charAt(prev.length() - 1));

        // return result.toString();
// iterative approch
    if (n == 1) return "1";

    String current = "1";

    for (int i = 2; i <= n; i++) {
        StringBuilder next = new StringBuilder();
        int count = 1;

        for (int j = 1; j < current.length(); j++) {
            if (current.charAt(j) == current.charAt(j - 1)) {
                count++;
            } else {
                next.append(count).append(current.charAt(j - 1));
                count = 1;
            }
        }
        next.append(count).append(current.charAt(current.length() - 1));
        current = next.toString();
    }

    return current;
    }
}