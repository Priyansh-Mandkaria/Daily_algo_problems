// Last updated: 6/22/2026, 1:35:05 PM
class Solution {
    public boolean partitionArray(int[] arr, int k) {
        int n = arr.length;
        if(n % k != 0) return false;
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int x : arr){
            m.merge(x,1,Integer::sum);
        }
        for(int x : m.values()){
            if(x > n/k)return false;
        }
        return true;
    }
}