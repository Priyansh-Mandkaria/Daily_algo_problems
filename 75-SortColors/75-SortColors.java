// Last updated: 7/10/2025, 8:58:56 AM
class Solution {
    public void sortColors(int[] arr) {
        //Dtuch National Flag Algorithm will be good here.
        // Why beacuse dnf algo use to sort an array consisting of 3 element
        int low = 0, mid = 0, high = arr.length-1;
        while(mid <= high){
            if(arr[mid] == 0){
                swap(arr,low,mid);
                low++;
                mid++;
            }
            else if(arr[mid] == 1){
                mid++;
            }
            else{
                swap(arr,mid,high);
                high--;
            }
        }
    }
    private void swap(int []arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b]  = temp;
    }
}