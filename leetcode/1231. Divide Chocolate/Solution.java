// https://leetcode.com/problems/divide-chocolate/description/
// using binary search + greedy
// t.c.=O(nlog(s/(k+1))), s.c.=O(1)
class Solution {
    public int numberOfPieces(int[] sweetness, int minSweetness) {
        int cnt=0, currTotalSweetness=0;
        for(int val:sweetness) {
            if(currTotalSweetness>=minSweetness) {
                currTotalSweetness=0;
                cnt++;
            }
            currTotalSweetness+=val;
        }
        cnt+=currTotalSweetness>=minSweetness?1:0;
        return cnt;
    }
    public int maximizeSweetness(int[] sweetness, int k) {
        int len=sweetness.length, left=Integer.MAX_VALUE, right=0;
        for(int val:sweetness) {
            left=Math.min(left, val);
            right+=val;
        }
        right/=(k+1);
        while(left<=right) {
            int mid=left+(right-left)/2;
            int pieces=numberOfPieces(sweetness, mid);
            if(pieces<(k+1))
                right=mid-1;
            else 
                left=mid+1;
        }
        return right;
    }
}
