// https://leetcode.com/problems/longest-turbulent-subarray/description/
// using brute force technique
// t.c.=O(n^2), s.c.=O(1)
class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int len=arr.length, maxLen=1;
        for(int i=0;i<len;i++) {
            for(int j=i+1;j<len;j++) {
                // check if arr[j] and arr[j-1] are equal
                if(arr[j]==arr[j-1])    break;
                // determine comparison sign: 1 for > and -1 for <
                int currSign=arr[j]>arr[j-1]?1:-1;
                if(j==i+1)
                    // for first pair any non-equal comparison is fine
                    maxLen=Math.max(maxLen, 2);
                else {
                    int prevSign=arr[j-1]>arr[j-2]?1:-1;
                    // if currSign and prevSign equals then break
                    if(currSign==prevSign)  break;
                    maxLen=Math.max(maxLen, j-i+1);
                }
            }
        }
        return maxLen;
    }
}

// using one pass
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int len=arr.length, maxLen=1, start=0, end=1;
        while(end<len) {
            if(arr[end]==arr[end-1]) {
                start=end++;
                continue;
            }
            if(end==start+1) 
                maxLen=Math.max(maxLen, 2);
            else {
                int currSign=arr[end]>arr[end-1]?1:-1;
                int prevSign=arr[end-1]>arr[end-2]?1:-1;
                if(prevSign!=currSign)
                    maxLen=Math.max(maxLen, end-start+1);
                else 
                    start=end-1;
            }
            end++;
        }
        return maxLen;
    }
}
