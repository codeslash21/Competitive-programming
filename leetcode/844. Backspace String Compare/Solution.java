// traversing from right
// t.c.=O(m+n), s.c.=O(1)
class Solution {
    public int nextValidChar(String str, int idx) {
        int backspace=0;
        while(idx>=0) {
            if(str.charAt(idx)=='#')    backspace++;
            else if(backspace>0)    backspace--;
            else    break;
            idx--;
        }
        return idx;
    }
    public boolean backspaceCompare(String s, String t) {
        int lenS=s.length(), lenT=t.length(), idx1=lenS-1, idx2=lenT-1;
        while(idx1>=0 || idx2>=0) {
            idx1=nextValidChar(s, idx1);
            idx2=nextValidChar(t, idx2);
            char charS=idx1>=0?s.charAt(idx1--):' ', charT=idx2>=0?t.charAt(idx2--):' ';
            if(charS!=charT)
                return false;
        }
        return idx1<0 && idx2<0?true:false;
    }
}
