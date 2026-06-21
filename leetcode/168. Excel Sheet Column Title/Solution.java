// https://leetcode.com/problems/excel-sheet-column-title/
// using base-26 conversion
// t.c.=O(log_26(n)), s.c.=O(log_26(n))
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb=new StringBuilder();
        while(columnNumber>0) {
            // shift from 1-indexed to 0-indexed
            columnNumber--;
            int remainder=columnNumber%26;
            sb.append((char)('A'+remainder));
            columnNumber/=26;
        }
        return sb.reverse().toString();
    }
}
