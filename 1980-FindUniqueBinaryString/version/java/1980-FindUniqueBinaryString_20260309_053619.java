// Last updated: 3/9/2026, 5:36:19 AM
1class Solution {
2    public String findDifferentBinaryString(String[] nums) {
3         int n = nums.length;
4        int[] base10 = new int[n];
5        for(int i = 0; i < n; i++)
6            for(int j = 0; j < n;j++)
7                base10[i] = (base10[i] << 1) | (nums[i].charAt(j) == '1' ? 1 : 0);
8        int counter = 0;
9        while(isInArr(counter++, base10));
10        return numToString(counter-1,n);   
11    }
12    public boolean isInArr(int num, int[] nums){
13        for(int i = 0; i < nums.length; i++)
14            if(nums[i] == num)
15                return true;
16        return false;
17    }
18    public String numToString(int num, int len){
19        StringBuilder sb = new StringBuilder(len);
20        for(int i = len-1; i >= 0; i--)
21            sb.append((char)(((num >>> i) & 1) + 48));
22        return sb.toString();
23    }
24}