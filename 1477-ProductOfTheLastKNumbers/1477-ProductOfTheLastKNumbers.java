// Last updated: 7/10/2025, 8:55:39 AM
class ProductOfNumbers {
 List<Integer> runningProduct;
    int mostRecentZeroIndex = 0;
    int size = 0;
    public ProductOfNumbers() {
        runningProduct = new ArrayList<>();
    }
    public void add(int num) {
        if(size == 0 || mostRecentZeroIndex == size-1)
            runningProduct.add(num);
        else
            runningProduct.add(num*runningProduct.get(size-1));  
        if(num == 0)
            mostRecentZeroIndex = size;
        else if(size == 0)
            mostRecentZeroIndex = -1;
        size++;
    }
    public int getProduct(int k) {
        int firstIndex = size-k;
        if(mostRecentZeroIndex < firstIndex){
            if(firstIndex-1 < 0 || runningProduct.get(firstIndex-1) == 0)
                return runningProduct.get(size-1);
            else
                return runningProduct.get(size-1)/runningProduct.get(size-k-1);
        }
        return 0;
    }
}
