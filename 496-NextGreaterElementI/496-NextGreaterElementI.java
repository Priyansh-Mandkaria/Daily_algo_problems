// Last updated: 7/10/2025, 8:57:27 AM
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
       int[] arr = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            boolean found = false;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    for (int k = j + 1; k < nums2.length; k++) {
                        if (nums2[k] > nums1[i]) {
                            arr[i] = nums2[k];
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        arr[i] = -1;
                    }
                    break;
                }
            }
        }
        return arr;
    }
}