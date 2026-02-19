// Last updated: 2/19/2026, 5:42:35 AM
1class Solution {
2    public boolean hasAlternatingBits(int n) {
3        int prev = 5;  
4        while(n > 0){
5            int bit = n % 2;  
6            n /= 2;          
7            if(prev == 5){
8                prev = bit;   
9            }else{
10                if(bit == prev) return false; 
11                prev = bit;
12            }
13        }
14        return true;
15    }
16}