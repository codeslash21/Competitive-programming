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

// sliding window
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int len=arr.length, cnt=0, sum=0;
        for(int i=0;i<len;i++) {
            sum+=arr[i];
            if(i>=k-1) {
                sum-=i>=k?arr[i-k]:0;
                cnt+=sum/k<threshold?0:1;
            }
        }
        return cnt;
    }
}
