// Last updated: 7/10/2025, 8:59:20 AM
class Solution {
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> ans=new ArrayList<>();
       List<Integer> in=new ArrayList<>();
       boolean[] used=new boolean[nums.length];
       Permutation(ans,in,used,nums);
       return ans;
    }
    private void Permutation( List<List<Integer>> out, List<Integer> in ,boolean[] use,int[] nums){
        if(in.size()==nums.length){
            out.add(new ArrayList<>(in));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(use[i])continue;
            use[i]=true;
            in.add(nums[i]);
            Permutation(out,in,use,nums);
            in.remove(in.size()-1);
            use[i]=false;
        }
    }
}