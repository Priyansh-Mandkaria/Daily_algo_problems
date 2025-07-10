// Last updated: 7/10/2025, 8:54:47 AM
class Solution {
    public double averageWaitingTime(int[][] customers) {
        double ans=0,curr=0,n=customers.length;
        for(int i=0;i<n;i++)
        {
            if(customers[i][0]>curr)
            {
                ans+=customers[i][1];
                curr=customers[i][0]+customers[i][1];
            }
            else
            {
                curr+=customers[i][1];
                ans+=curr-customers[i][0];
            }
        }
        return ans/n;
    }
}