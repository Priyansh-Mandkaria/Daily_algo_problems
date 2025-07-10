// Last updated: 7/10/2025, 8:57:46 AM
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0 ; i < nums1.length ; i++){
            int t = nums1[i];
            boolean test = 
            Arrays.stream(nums2).anyMatch(x -> x == t);
            if (test) {
                arr.add(nums1[i]);
                // Remove the element from nums2 by setting it to a value that will not be found again
                for (int j = 0; j < nums2.length; j++) {
                    if (nums2[j] == t) {
                        nums2[j] = Integer.MIN_VALUE; // Assuming nums1 and nums2 do not contain Integer.MIN_VALUE
                        break;
                    }
                }
            }
        }
        int[] arr2 = new int[arr.size()];
        for(int i = 0 ; i < arr2.length ; i++){
            arr2[i] = arr.get(i);
        }
        return arr2;
    }
}