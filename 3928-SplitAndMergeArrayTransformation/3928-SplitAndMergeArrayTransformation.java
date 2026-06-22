// Last updated: 6/22/2026, 1:35:39 PM
class Solution {
    public boolean check(int arr1[],int arr2[]){
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
    int global[];
    HashMap<String,Integer> dp;
    public int helper(int arr[],int i,int count){
        if(i>=arr.length){
            return 10000000;
        }
        if(count>4){//check count before submitting
            return 10000000;
        }
        if(check(arr,global)){
            return 0;
        }
        String key=Arrays.toString(arr)+" | "+i+" | "+count;
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        //do something
        int something=Integer.MAX_VALUE;
        for(int j=i;j<arr.length;j++){
            int l=i;
            int r=j;
            List<Integer> lTor=new ArrayList<>();
            List<Integer> remain=new ArrayList<>();
            for(int k=0;k<arr.length;k++){
                if(k>=l && k<=r){
                    lTor.add(arr[k]);
                }
                else{
                    remain.add(arr[k]);
                }
            }
            
            for(int k=0;k<remain.size();k++){
                int newArr[]=new int[arr.length];
                int ct=0;
                while(ct<=k){
                    newArr[ct]=remain.get(ct);
                    ct++;
                }
                for(int kl:lTor){
                    newArr[ct++]=kl;
                }
                for(int kl=k+1;kl<remain.size();kl++){
                    newArr[ct++]=remain.get(kl);
                }
                something=Math.min(something,1+helper(newArr,0,count+1));
            }
            int newArr1[]=new int[arr.length];
            int newArr2[]=new int[arr.length];
            int ct1=0;
            for(int kl:lTor){
                newArr1[ct1++]=kl;
            }
            for(int kl:remain){
                newArr1[ct1++]=kl;
            }
            ct1=0;
            for(int kl:remain){
                newArr2[ct1++]=kl;
            }
            for(int kl:lTor){
                newArr2[ct1++]=kl;
            }
            something=Math.min(something,1+helper(newArr1,0,count+1));
            something=Math.min(something,1+helper(newArr2,0,count+1));
            
        }
        //do nothing
        int nothing=helper(arr,i+1,count);
        dp.put(key,Math.min(something,nothing));
        return Math.min(something,nothing);
    }
    public int minSplitMerge(int[] nums1, int[] nums2) {
        this.dp=new HashMap<>();
        this.global=nums2;
        return helper(nums1,0,0);
    }
}