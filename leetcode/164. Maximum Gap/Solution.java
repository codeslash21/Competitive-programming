// https://leetcode.com/problems/maximum-gap/description/
// using bucket sort
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int maximumGap(int[] nums) {
        int len=nums.length, minValue=Integer.MAX_VALUE, maxValue=Integer.MIN_VALUE;
        for(int num:nums) {
            minValue=Math.min(minValue, num);
            maxValue=Math.max(maxValue, num);
        }
        if(len<2 || minValue==maxValue) return 0;
        // logic for bucket
        int bucketWidth=Math.max(1, (maxValue-minValue)/(len-1));
        int bucketCount=(maxValue-minValue)/bucketWidth+1;
        int[] bucketMin=new int[bucketCount], bucketMax=new int[bucketCount];
        boolean[] bucketUsed=new boolean[bucketCount];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        // place elements in buckets
        for(int num:nums) {
            int bucket=(num-minValue)/bucketWidth;
            bucketUsed[bucket]=true;
            bucketMin[bucket]=Math.min(bucketMin[bucket], num);
            bucketMax[bucket]=Math.max(bucketMax[bucket], num);
        }
        // get max gap
        int maxGap=0, prevMax=minValue;
        for(int i=0;i<bucketCount;i++) {
            if(!bucketUsed[i])  continue;
            maxGap=Math.max(maxGap, bucketMin[i]-prevMax);
            prevMax=bucketMax[i];
        }
        return maxGap;
    }
}
