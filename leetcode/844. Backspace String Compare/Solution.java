// traversing from right
// t.c.=O(m+n), s.c.=O(1)
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int ls=s.length()-1, lt=t.length()-1;
        int skips=0, skipt=0;
        while(ls>=0 || lt>=0) {
            while(ls>=0) {
                if(s.charAt(ls)=='#')   {skips++; ls--;}
                else if(skips>0)    {skips--; ls--;}
                else    break;
            }
            while(lt>=0) {
                if(t.charAt(lt)=='#')   {skipt++; lt--;}
                else if(skipt>0)    {skipt--; lt--;}
                else    break;
            }
            if(ls>=0 && lt>=0 && s.charAt(ls)!=t.charAt(lt))
                return false;
            if((ls>=0)!=(lt>=0))
                return false;
            ls--; lt--;
        }
        return true;
    }
}
