// Last updated: 10/24/2025, 10:53:19 AM
import java.util.*;

class Solution {
    private static final TreeSet<Long> balancedNumbers = initBalancedNumbers();

    private static TreeSet<Long> initBalancedNumbers() {
        TreeSet<Long> s = new TreeSet<>();
        List<String> bases = Arrays.asList(
            "1", "22", "122", "333", "1333", "4444", "14444", "22333", "55555",
            "122333", "155555", "224444", "666666", "1224444", "1666666",
            "2255555", "3334444", "7777777", "12255555"
        );

        for (String base : bases) {
            char[] chars = base.toCharArray();
            Arrays.sort(chars);
            do {
                s.add(Long.parseLong(new String(chars)));
            } while (nextPermutation(chars));
        }
        return s;
    }

    private static boolean nextPermutation(char[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) i--;
        if (i < 0) return false;
        int j = arr.length - 1;
        while (arr[j] <= arr[i]) j--;
        swap(arr, i, j);
        reverse(arr, i + 1, arr.length - 1);
        return true;
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(char[] arr, int i, int j) {
        while (i < j) swap(arr, i++, j--);
    }

    public int nextBeautifulNumber(int n) {
        Long next = balancedNumbers.higher((long) n);
        return next != null ? next.intValue() : -1;
    }
}