// Last updated: 7/10/2025, 8:50:36 AM
class Solution {
    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> good_mount = new ArrayList<>();
        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] > threshold) {
                good_mount.add(i);
            }
        }
        return good_mount;
    }
}