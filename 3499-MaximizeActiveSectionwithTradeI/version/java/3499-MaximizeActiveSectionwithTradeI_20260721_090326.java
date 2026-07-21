// Last updated: 7/21/2026, 9:03:26 AM
1class Solution {
2    public int maxActiveSectionsAfterTrade(String s) {
3        char[] arr = s.toCharArray();
4        int n = arr.length;
5
6        int count1 = 0;
7
8        int block1 = 0;
9        int block2 = 0;
10        int maxx = 0;
11
12        int i = 0;
13        while(i<n){
14            char ch = arr[i];
15
16            if(ch=='0') {
17                block1++;
18                i++;
19            }
20
21            else{
22                while(i<n && ch=='1'){
23                    i++;
24                    count1++;
25                    if(i!=n)ch=arr[i];
26                }
27                
28                while(i<n && ch=='0'){
29                    i++;
30                    block2++;
31                    if(i!=n)ch=arr[i];
32                }
33
34                if(block1!=0 && block2!=0) maxx = Math.max(maxx, block1+block2);
35                block1 = block2;
36                block2 = 0;
37            }
38
39        }
40
41        return count1 + maxx;
42
43    }
44}