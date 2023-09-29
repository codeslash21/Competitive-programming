// using prefix sum
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n=arr.length, cnt=0;
        double[] preSum = new double[n+1];
        for(int i=0;i<n;i++)
            preSum[i+1]=preSum[i]+arr[i];
        for(int i=0;i<=n-k;i++)
            if((preSum[i+k]-preSum[i])/k>=threshold)
                cnt++;
        return cnt;
    }
}
