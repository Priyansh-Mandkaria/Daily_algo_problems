// Last updated: 7/10/2025, 8:49:02 AM
class Solution {
    private boolean checkprime(int n){
        if(n <= 1){
            return false;
        }
        for(int i = 2 ; i*i <= n;i++){
            if(n % i == 0){
                return false;//not prime
            }
        }
        return true;
    }
    public boolean checkPrimeFrequency(int[] arr) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int x : arr){
            mp.put(x,mp.getOrDefault(x,0)+1);// here we are increase the number of count per element
        }
        for(int c : mp.values()){
            if(checkprime(c)){
                return true;
            }
        }
        return false;
    }
}