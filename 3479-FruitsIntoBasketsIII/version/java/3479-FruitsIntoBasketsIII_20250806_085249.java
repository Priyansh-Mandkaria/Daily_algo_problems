// Last updated: 8/6/2025, 8:52:49 AM
class Solution {
    private int N;
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int unPlacedCount = 0;
        N = baskets.length - 1;
        int size = 4 * baskets.length;
        int[] segmentTree = new int[size];
        constructTree(0, 0, N, baskets, segmentTree);

        for (int f : fruits) {
            if (!findBasket(f, 0, 0, N, segmentTree)) {
                unPlacedCount++;
            }
        }
        return unPlacedCount;
    }

    private boolean findBasket(int noOfFruits, int idx, int l, int r, int[] segmentTree) {
        if (noOfFruits > segmentTree[idx]) {
            return false;
        }
        if (l == r) {
            updateTree(0, 0, N, l, segmentTree);
            return true;
        }

        int mid = (r - l) / 2 + l;

        if (findBasket(noOfFruits, 2 * idx + 1, l, mid, segmentTree)) {
            return true;
        }
        return findBasket(noOfFruits, 2 * idx + 2, mid + 1, r, segmentTree);
    }

    private int constructTree(int idx, int l, int r, int[] arr, int[] segmentTree) {
        if (l == r) {
            segmentTree[idx] = arr[l];
            return arr[l];
        }
        int mid = (r - l) / 2 + l;
        int leftTree = constructTree(2 * idx + 1, l, mid, arr, segmentTree);
        int rightTree = constructTree(2 * idx + 2, mid + 1, r, arr, segmentTree);

        segmentTree[idx] = Math.max(leftTree, rightTree);
        return segmentTree[idx];
    }

    private int updateTree(int idx, int l, int r, int arrIdx, int[] segmentTree) {
        if (l > arrIdx || r < arrIdx) {
            return segmentTree[idx];
        }
        
        if (l == r) {
            segmentTree[idx] = 0;
            return 0;
        }

        int mid = (r - l) / 2 + l;
        int leftTree = updateTree(2 * idx + 1, l, mid, arrIdx, segmentTree);
        int rightTree = updateTree(2 * idx + 2, mid + 1, r, arrIdx, segmentTree);
        segmentTree[idx] = Math.max(leftTree, rightTree);

        return segmentTree[idx];
    }

}