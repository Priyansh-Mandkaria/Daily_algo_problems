// Last updated: 8/8/2026, 8:48:11 AM
1class Solution {
2    public int[] validSequence(String word1, String word2) {
3        int length1 = word1.length();
4        int length2 = word2.length();
5        int[] indices = new int[length1];
6        int j = length2 - 1;
7        for (int i = length1 - 1; i >= 0; i--) {
8            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
9                indices[i] = (i == length1 - 1) ? 1 : indices[i + 1] + 1;
10                j--;
11            } else {
12                indices[i] = (i == length1 - 1) ? 0 : indices[i + 1];
13            }
14        }
15        j = 0;
16        List<Integer> result = new ArrayList<>();
17        int finalIndex = -1;
18        for (int i = 0; i < length1; i++) {
19            if (word1.charAt(i) == word2.charAt(j)) {
20                result.add(i);
21                j++;
22                if (j == length2) {
23                    break;
24                }
25            } else {
26                if ((i == length1 - 1 ? 0 : indices[i + 1]) >= length2 - j - 1) {
27                    result.add(i);
28                    j++;
29                    finalIndex = i + 1;
30                    break;
31                }
32            }
33        }
34        if (result.size() == length2) {
35            return convertToArray(result);
36        }
37        if (finalIndex == -1) {
38            return new int[0];
39        }
40        for (int i = finalIndex; i < length1; i++) {
41            if (word1.charAt(i) == word2.charAt(j)) {
42                result.add(i);
43                j++;
44            }
45            if (j == length2) {
46                break;
47            }
48        }
49        return result.size() == length2 ? convertToArray(result) : new int[0];
50    }
51    private int[] convertToArray(List<Integer> list) {
52        return list.stream().mapToInt(Integer::intValue).toArray();
53    }
54}