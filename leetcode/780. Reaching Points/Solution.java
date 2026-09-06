// https://leetcode.com/problems/reaching-points/description/
// using modulo operator
// t.c.=O(log(max(tx, ty))), s.c.=O(1)
class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while(tx>=sx && ty>=sy) {
            if(tx>ty)
                if(ty>sy)   tx%=ty;
                else    return (tx-sx)%ty==0;
            else
                if(tx>sx)   ty%=tx;
                else    return (ty-sy)%tx==0;
        }
        return false;
    }
}
