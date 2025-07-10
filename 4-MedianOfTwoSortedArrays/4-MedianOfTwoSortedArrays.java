// Last updated: 7/10/2025, 9:00:04 AM
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int z = m + n;
        double[] a = new double[z];
        for(int i = 0 ; i < m ; i++){
            a[i] = nums1[i];
        }
        for(int i = 0 ; i < n ; i++){
            a[i + m] = nums2[i];
        }
        Arrays.sort(a);
        if(z % 2 != 0){
            int j = (z+1)/2 ;
            return a[j-1];
        }
        else{
            int k = (z/2);
            int l = (z/2)+1;
            return (a[k-1] + a[l-1])/2;
        }
    }
}