// https://leetcode.com/problems/adding-spaces-to-a-string/
// t.c.=O(m+n), s.c.=O(m+n)
class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb=new StringBuilder();
        int lenS=s.length(), lenSpace=spaces.length, strIdx=0, spaceIdx=0;
        for(;strIdx<lenS;strIdx++) {
            if(spaceIdx< lenSpace && strIdx==spaces[spaceIdx]) {
                sb.append(' ');
                spaceIdx++;
            }
            sb.append(s.charAt(strIdx));
        }
        return sb.toString();
    }
}
