// Last updated: 7/10/2025, 8:54:03 AM
class Solution {
    public String findDifferentBinaryString(String[] nums) {
         int n = nums.length;
        int[] base10 = new int[n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n;j++)
                base10[i] = (base10[i] << 1) | (nums[i].charAt(j) == '1' ? 1 : 0);
        int counter = 0;
        while(isInArr(counter++, base10));
        return numToString(counter-1,n);   
    }
    public boolean isInArr(int num, int[] nums){
        for(int i = 0; i < nums.length; i++)
            if(nums[i] == num)
                return true;
        return false;
    }
    public String numToString(int num, int len){
        StringBuilder sb = new StringBuilder(len);
        for(int i = len-1; i >= 0; i--)
            sb.append((char)(((num >>> i) & 1) + 48));
        return sb.toString();
    }
}