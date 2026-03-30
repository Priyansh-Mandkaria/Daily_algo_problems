// Last updated: 3/30/2026, 6:20:51 AM
1class Solution {
2    public boolean checkStrings(String s1, String s2) {
3        int[] even = new int[26];
4        int[] odd = new int[26];
5
6    for(int i = 0; i < s1.length(); i++) {
7
8        if(i % 2 == 0) {
9            even[s1.charAt(i) - 'a']++;
10            even[s2.charAt(i) - 'a']--;
11        } else {
12            odd[s1.charAt(i) - 'a']++;
13            odd[s2.charAt(i) - 'a']--;
14        }
15    }
16
17    for(int i = 0; i < 26; i++) {
18        if(even[i] != 0) return false;
19        if(odd[i] != 0) return false;
20    }
21
22    return true;
23    }
24}