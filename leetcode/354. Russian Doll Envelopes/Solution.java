// https://leetcode.com/problems/russian-doll-envelopes/description/
// using dp
// t.c.=O(n^2), s.c.=O(n)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b)->a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]);
        int n=envelopes.length, maxLen=1;
        int[] dp=new int[n];
        Arrays.fill(dp, 1);
        for(int i=1;i<n;i++) {
            for(int j=0;j<i;j++)
                if(envelopes[j][0]<envelopes[i][0] && envelopes[j][1]<envelopes[i][1])
                    dp[i]=Math.max(dp[i], dp[j]+1);
            maxLen=Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}

// using sorting and binary search
// t.c.=O(nlogn), s.c.=O(n)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b)->a[0]!=b[0]?a[0]-b[0]:b[1]-a[1]);
        int n=envelopes.length, maxLen=1;
        List<Integer> dp=new ArrayList<>();
        int[] envelopeHeights=new int[n];
        for(int i=0;i<n;i++)    envelopeHeights[i]=envelopes[i][1];
        dp.add(envelopeHeights[0]);
        for(int i=1;i<n;i++) {
            if(envelopeHeights[i]>dp.get(dp.size()-1)) {
                dp.add(envelopeHeights[i]);
                maxLen++;
            } else {
                int idx=Collections.binarySearch(dp, envelopeHeights[i]);
                if(idx<0)   idx=-idx-1;
                dp.set(idx, envelopeHeights[i]);
            }
        }
        return maxLen;
    }
}
