// Last updated: 7/10/2025, 8:55:27 AM
class Solution {
    public int findLucky(int[] arr) {
        int lucky = -1;
        HashMap<Integer,Integer> map  = new HashMap<>();
        for(int i =  0; i < arr.length; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+ 1);
        }
        for(HashMap.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getKey() == entry.getValue()) {
                if(lucky < entry.getKey()) lucky = entry.getKey();
            }
        }
        return lucky;
    }
}