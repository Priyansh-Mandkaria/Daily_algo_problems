// Last updated: 7/10/2025, 8:55:01 AM
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drinked = numBottles;
        int remain = 0;
        while(numBottles/numExchange != 0){
            remain = numBottles % numExchange;
            numBottles = numBottles/numExchange;
            drinked = drinked + numBottles;
            numBottles = numBottles + remain;           
        }
        return drinked;
    }
}