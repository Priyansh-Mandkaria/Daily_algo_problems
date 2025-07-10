# Last updated: 7/10/2025, 8:51:46 AM
class Solution:
    def maximumTripletValue(self, a: List[int]) -> int:
        return max(max(accumulate(map(mul,accumulate(map(sub,accumulate(a,max),a[1:]),max),a[2:]),max)),0)