// Last updated: 6/22/2026, 1:35:42 PM
class Solution {
    public int minMoves(int sx, int sy, int tx, int ty) {
        if(sx==0 && sy==0)
            if(tx==0 && ty==0)
                return 0;
            else
                return -1;
        int res = 0;
        while(tx>=sx && ty>=sy){
            if(tx==sx && ty==sy)
                return res;
            if(Math.max(tx,ty)>=2*Math.min(tx,ty))
                if(Math.max(tx,ty)%2==0)
                    if(tx>ty)
                        tx/=2;
                    else
                        ty/=2;
                else
                    return -1;
            else
                if(tx>ty || (tx==ty && sx<sy))
                    tx-=ty;
                else
                    ty-=tx;
            res++;
        }
        return -1;
    }
}