// Last updated: 7/10/2025, 8:53:46 AM
class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        int a = tasks.length, b = workers.length;
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int l = 0, r = Math.min(a, b);
        while(l <= r){
            int mid = l + r >> 1;
            if(check(tasks, workers, pills, strength, mid, b - mid))
                l = mid+1;
            else
                r = mid-1;
        }
        return r;
    } 
    public boolean check(int[] tasks, int[] workers, int pills, int strength, int mid, int start){        
        int[] que = new int[mid];
        int write = 0, read = 0; 
        for(int i = 0, j = 0; i < mid; i++){
            int curStrength  = workers[start + i];
            if(read == write){
                if(curStrength >= tasks[j]){
                    j++;
                    continue;
                }
                if(pills == 0)
                    return false;                
                curStrength  += strength;
                pills--;
                while(j < mid && curStrength >= tasks[j])
                    que[write++] = tasks[j++];                
                if(read == write)
                    return false;
                write--;                
            }else{
                if(curStrength >= que[read]){
                    read++;
                    continue;
                }
                if(pills == 0)
                    return false;                
                curStrength  += strength;
                pills--;
                while(j < mid && curStrength >= tasks[j])
                    que[write++] = tasks[j++];             
                write--;
            }
        }
        return read == write;        
    }
}