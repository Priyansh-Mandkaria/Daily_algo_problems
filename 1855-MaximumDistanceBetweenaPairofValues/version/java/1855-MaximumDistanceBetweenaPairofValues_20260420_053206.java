// Last updated: 4/20/2026, 5:32:06 AM
1class Solution {
2    public int maxDistance(int[] colors) {
3        int i=0, j=colors.length-1;
4        int count = 0, count1 = 0;
5
6        while(i<j){
7            if(colors[i]!=colors[j]){
8                count = j-i;
9                break;
10            }
11            j--;
12        }
13        i=0;
14        j=colors.length-1;
15        while(i<j){
16            if(colors[i]!=colors[j]){
17                count1 = j-i;
18                break;
19            }
20            i++;
21        }
22        return Math.max(count, count1);
23    }
24}