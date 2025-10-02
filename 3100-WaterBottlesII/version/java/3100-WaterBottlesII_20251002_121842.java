// Last updated: 10/2/2025, 12:18:42 PM
class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int bottleDrunk = numBottles;
        int emptyBottles = numBottles;
        while (emptyBottles >= numExchange) {
            emptyBottles -= numExchange; 
            numExchange++;               
            bottleDrunk++;               
            emptyBottles++;            
        }
        return bottleDrunk;
    }
}