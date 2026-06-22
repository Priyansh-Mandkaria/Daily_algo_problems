// Last updated: 6/22/2026, 1:34:30 PM
class Solution {
    public long splitArray(int[] a) {
        int n=a.length;
        long tot=Arrays.stream(a).asLongStream().sum();
        int k=(int)IntStream.range(0,n-1).takeWhile(i->a[i]<a[i+1]).count();
        int r=(int)IntStream.iterate(n-2,i->i>=0,i->i-1).takeWhile(i->a[i]>a[i+1]).count();
        int lb=Math.max(0,n-2-r), ub=Math.min(k,n-2);
        AtomicLong pref=new AtomicLong();
        long ans=IntStream.range(0,n-1).mapToLong(i->{long L=pref.addAndGet(a[i]);return i>=lb&&i<=ub?Math.abs(L-(tot-L)):Long.MAX_VALUE;}).min().orElse(Long.MAX_VALUE);
    return ans==Long.MAX_VALUE?-1:ans;
    }
}