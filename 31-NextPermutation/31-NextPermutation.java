// Last updated: 7/10/2025, 8:59:38 AM
class Solution {
    public void nextPermutation(int[] arr) {
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        int n = A.size(); 
        int ind = -1; 
        for (int i = n - 2; i >= 0; i--) {
            if (A.get(i) < A.get(i + 1)) {
                ind = i;
                break;
            }
        }
        if (ind == -1) {
            Collections.reverse(A);
        }
        else{
        for (int i = n - 1; i > ind; i--) {
            if (A.get(i) > A.get(ind)) {
                int tmp = A.get(i);
                A.set(i, A.get(ind));
                A.set(ind, tmp);
                break;
            }
        }
        List<Integer> sublist = A.subList(ind + 1, n);
        Collections.reverse(sublist);
        }
        for (int i = 0; i < n; i++) {
            arr[i] = A.get(i);
        }
    }
}