// Last updated: 2/20/2026, 12:40:16 PM
1class Solution {
2    public String makeLargestSpecial(String s) {
3        int cnt =0;
4        List<String> list = new LinkedList<>();
5        int j=0;
6        for(int i=0;i<s.length();i++)
7        {
8            if(s.charAt(i)=='1')
9                cnt++;
10            else cnt--;
11            if(cnt==0)
12            {
13                list.add('1'+makeLargestSpecial(s.substring(j+1,i))+'0');
14                j= i+1;
15            }
16        }
17        Collections.sort(list,Collections.reverseOrder());
18        return String.join("",list);
19    }
20}