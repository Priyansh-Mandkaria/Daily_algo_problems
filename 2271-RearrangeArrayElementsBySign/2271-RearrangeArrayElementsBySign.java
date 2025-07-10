// Last updated: 7/10/2025, 8:53:26 AM
class Solution {
    public int[] rearrangeArray(int[] arr) {
        ArrayList<Integer>  pos = new ArrayList<>();
        ArrayList<Integer>  neg = new ArrayList<>();
        for(int i = 0; i < arr.length ; i++){
            if(arr[i] > 0 ) pos.add(arr[i]);
            else neg.add(arr[i]);
        }
        for(int i = 0 ; i < arr.length/2; i++){
            arr[i*2] = pos.get(i);
            arr[i*2+1] = neg.get(i); 
        }
        return arr;
    }
}