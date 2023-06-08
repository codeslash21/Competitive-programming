// Right to left traversal
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int titleToNumber(String columnTitle) {
        char[] arr = columnTitle.toCharArray();
        int n=arr.length;
        int res=0, factor=1;
        for(int i=n-1;i>=0;i--) {
            int val = arr[i]-'A'+1;
            res+=(val*factor);
            factor*=26;
        }
        return res;
    }
}
