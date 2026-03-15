// Last updated: 3/15/2026, 6:01:22 AM
1class Solution {
2    public String getHappyString(int n, int k) {
3        char[] arr = {'a', 'b', 'c'};
4        String res="";
5        List<String> l=new ArrayList<>();
6        generatePerm(arr, n, res, l);
7        if(l.size() >= k)
8            res=l.get(k-1);
9        return res;
10    }
11    
12    private void generatePerm(char[] arr, int n, String res, List<String> l){
13        if(n == 0){
14            l.add(res);
15            return;
16        }
17        
18        for(int i=0; i<arr.length; i++){
19           if(res == "" || res.charAt(res.length()-1) != arr[i]){
20                String pre=res+arr[i];
21                generatePerm(arr, n-1, pre, l);
22            }
23        }
24    }
25}