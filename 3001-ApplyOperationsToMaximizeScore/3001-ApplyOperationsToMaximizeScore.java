// Last updated: 7/10/2025, 8:51:53 AM
class Solution {
    int M = (int)(1e9+7) ; 
    public int maximumScore(List<Integer> nums, int k) {
        int n = nums.size() ; 
        int s[] = new int[n] ; 
         PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0]) return a[0]>b[0]?-1:1 ;  
            return a[1]>b[1]?-1:1 ; 
        }) ; 
        
        Stack<int[]> st = new Stack<>() ; 
        int[] right = new int[n] ;
        
        for(int i=n-1 ; i>=0 ; i--) {             // O(n)
            s[i] = prime_score(nums.get(i)) ;
            int len = 0 ;
            while(! st.isEmpty() && st.peek()[0]<= s[i]) st.pop() ; 
            if(st.isEmpty())len = n-i ; 
            else len = st.peek()[1] - i ; 
            right[i] = len ; 
            st.push(new int[]{s[i] , i}) ;             
        } 
        st = new Stack<>() ; 

        for(int i=0 ; i<n ; i++){       // O(n)
            long len = 0 ; 
            while(! st.isEmpty() && st.peek()[0]<s[i])   st.pop() ;
            if(st.isEmpty()) len = i+1 ; 
            else len = i-st.peek()[1] ; 
            st.push(new int[]{s[i] , i}) ; 
            long range = len* right[i] ; 

            pq.add(new long[]{nums.get(i) , range}) ; 
        }
        long ans = 1 ;  
        while(k>0){
            long [] p = pq.poll() ;
            long num = p[0] , range = p[1] ; 
            int y = (int)Math.min(range , k) ; 
            ans *= exponentiate(num , y) ;    // O(log(k))
            ans %=M ; 
            k -= y ;
        }
        return (int)ans ; 
    }
    private int prime_score(int x){   //O(sqrt(x))
        int ct = 0 ; 
        for(int i=2 ; i*i<= x ; i++){
            if(x%i==0){
                ct++ ; 
                while(x%i==0) x/=i ; 
            }
        }
        if(x>1) ct++ ; 
        return ct ; 
    }
    private int exponentiate(long a , int b){
        long x = a ; 
        long ans = 1 ; 
        while(b>0){
            if((b&1)==1) {
                ans *= x ; 
                ans%=M ; 
            }
            x *=x ; 
            x%=M ; 
            b>>=1 ; 
        }
        return (int)ans ; 
    }
}