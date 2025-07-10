// Last updated: 7/10/2025, 8:59:52 AM
class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        List<List<Integer>> arr2 = new ArrayList<>();
        int n = arr.length;
        long sum = 0;
        Arrays.sort(arr);
        for(int i = 0 ; i < n; i++){
            if(i > 0 && arr[i] == arr[i - 1]) continue;
            for(int j = i + 1 ; j < n ; j++){
                if(j > i+1 && arr[j] == arr[j - 1]) continue;
                int k = j + 1;
                int l = n - 1;
                while(k < l){
                    sum = 1L * arr[i] + arr[j] + arr[k] + arr[l];
                    if(sum > target) l--;
                    else if(sum < target) k++;
                    else{
                        List<Integer> temp  = Arrays.asList(arr[i],arr[j],arr[k],arr[l]); 
                        arr2.add(temp);
                        k++;
                        l--;
                        while(k < l && arr[k] == arr[k - 1]) k++;
                        while(k < l && arr[l] == arr[l + 1]) l--;
                    }
                }
            }
        }
        return arr2;
    }
}