// https://leetcode.com/problems/random-pick-with-weight/description/
// prefix sum + linear search
// t.c.=O(n), s.c.=O(n)
class Solution {
    int[] prefixSums;
    int totalSum, len;
    public Solution(int[] w) {
        this.len=w.length;
        this.prefixSums=new int[len];
        int prefixSum=0;
        for(int i=0;i<len;i++) {
            prefixSum+=w[i];
            prefixSums[i]=prefixSum;
        }
        totalSum=prefixSum;
    }
    
    public int pickIndex() {
        double target=totalSum * Math.random();
        for(int i=0;i<len;i++)
            if(target<=prefixSums[i])
                return i;
        return len-1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */

// prefix sum + binary search
// t.c.=O(n), s.c.=O(n)
class Solution {
    int[] prefixSums;
    int totalSum, len;
    public Solution(int[] w) {
        this.len=w.length;
        this.prefixSums=new int[len];
        int prefixSum=0;
        for(int i=0;i<len;i++) {
            prefixSum+=w[i];
            prefixSums[i]=prefixSum;
        }
        totalSum=prefixSum;
    }
    
    public int pickIndex() {
        double target=totalSum * Math.random();
        int left=0, right=len-1;
        while(left<right) {
            int mid=left+(right-left)/2;
            if(target>prefixSums[mid])
                left=mid+1;
            else
                right=mid;
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
