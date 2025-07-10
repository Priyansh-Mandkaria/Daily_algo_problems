// Last updated: 7/10/2025, 8:52:27 AM
class Solution {
    public long pickGifts(int[] gifts, int k) {
        for(int i = 0 ; i < k; i++){
             int maxIndex = 0;
            for (int j = 1; j < gifts.length; j++) {
                if (gifts[j] > gifts[maxIndex]) {
                    maxIndex = j;
                }
            }
            gifts[maxIndex] = (int)(Math.sqrt(gifts[maxIndex]));
        }
        long remaining = 0;
        for (long gift : gifts) {
            remaining += gift;
        }
        return remaining;
    }
}