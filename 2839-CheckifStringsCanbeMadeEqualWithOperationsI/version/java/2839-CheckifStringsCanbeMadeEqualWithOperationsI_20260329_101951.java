// Last updated: 3/29/2026, 10:19:51 AM
1class Solution {
2    public boolean canBeEqual(String s1, String s2) {
3        char[] arr1 = s1.toCharArray();
4        if (String.valueOf(arr1).equals(s2)) return true;
5        swap(arr1, 0, 2);
6        if (String.valueOf(arr1).equals(s2)) return true;
7        swap(arr1, 1, 3);
8        if (String.valueOf(arr1).equals(s2)) return true;
9        swap(arr1, 0, 2);
10        if (String.valueOf(arr1).equals(s2)) return true;
11        return false;
12    }
13    public void swap(char[] arr, int a, int b){
14        char temp = arr[a];
15        arr[a] = arr[b];
16        arr[b] = temp;
17    }
18}