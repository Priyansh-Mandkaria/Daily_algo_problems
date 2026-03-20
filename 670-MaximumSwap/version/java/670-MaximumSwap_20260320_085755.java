// Last updated: 3/20/2026, 8:57:55 AM
1class Solution {
2    public int maximumSwap(int num) {
3    int maxIndex = -1, swap1 =-1, swap2=-1 ;
4    char nums[] = Integer.toString(num).toCharArray();
5    int n = nums.length;
6
7    for(int i=n-1; i>=0; i--)
8    {
9      if(maxIndex==-1 || nums[i]>nums[maxIndex])
10      {
11        maxIndex = i; 
12      } 
13      else if(nums[i]<nums[maxIndex])
14      {
15        swap1 = i;
16        swap2 = maxIndex;
17      }  
18    }
19
20    if(swap1!=-1 && swap2!=-1)
21    {
22       char temp = nums[swap1];
23       nums[swap1] = nums[swap2];
24       nums[swap2] = temp;
25    }
26      return Integer.parseInt(new String(nums)) ;
27    }
28}