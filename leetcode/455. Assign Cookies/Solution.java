// https://leetcode.com/problems/assign-cookies/description/
// Using TreeMap
// t.c.=O(nlogn + mlogn), s.c.=O(n), m=len(g), n=len(s)
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int lenG=g.length, lenS=s.length, count=0;
        TreeMap<Integer, Integer> cookieSizes=new TreeMap<>();
        for(int size:s)
            cookieSizes.put(size, cookieSizes.getOrDefault(size, 0)+1);
        for(int greed:g) {
            Integer allocatedCookieSize=cookieSizes.ceilingKey(greed);
            if(allocatedCookieSize==null)
                continue;
            count++;
            if(cookieSizes.get(allocatedCookieSize)==1)
                cookieSizes.remove(allocatedCookieSize);
            else
                cookieSizes.put(allocatedCookieSize, cookieSizes.get(allocatedCookieSize)-1);
        }
        return count;
    }
}

// Using sorting + two pointers
// t.c.=O(nlogn + mlogm), s.c.=O(logn + logm)
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int lenG=g.length, lenS=s.length, idx1=0, idx2=0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(idx1<lenG && idx2<lenS) {
            if(g[idx1]<=s[idx2]) 
                idx1++;
            idx2++;
        }
        return idx1;
    }
}
