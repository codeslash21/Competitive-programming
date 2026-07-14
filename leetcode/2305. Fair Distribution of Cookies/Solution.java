// https://leetcode.com/problems/fair-distribution-of-cookies/description/
// using backtracking
// t.c.=O(k^n), s.c.=O(n+k)
class Solution {
    private int result=Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        Arrays.sort(cookies);
        for(int l=0,r=cookies.length-1;l<r;l++,r--) {
            int temp=cookies[l]; cookies[l]=cookies[r]; cookies[r]=temp;
        }
        backtrack(cookies, new int[k], k, 0);
        return result;
    }
    private void backtrack(int[] cookies, int[] children, int k, int bag) {
        // if we have assigned all cookies
        if(bag==cookies.length) {
            int maxCookie=0;
            for(int cookie:children)
                maxCookie=Math.max(maxCookie, cookie);
            result=Math.min(result, maxCookie);
            return;
        }
        for(int i=0;i<children.length;i++) {
            if(children[i]+cookies[bag]>result) continue;
            children[i]+=cookies[bag];
            backtrack(cookies, children, k, bag+1);
            children[i]-=cookies[bag];
        }
    }
}
