// Using custom comparator
// t.c.=O(nlogn + klogk), s.c.=O(n)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> sorted = new ArrayList<>();
        for(int num:arr)
            sorted.add(num);
        Collections.sort(sorted, (a,b)->Math.abs(a-x)-Math.abs(b-x));
        sorted=sorted.subList(0,k);
        Collections.sort(sorted);
        return sorted;
    }
}

// Using sliding window
// t.c.=O(n), s.c.=O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int len=arr.length, left=0, right=0, finalLeft=0, finalRight=k-1, prevSum=0;
        List<Integer> res=new ArrayList<>();
        while(right<k)
            prevSum+=Math.abs(x-arr[right++]);
        while(right<len) {
            int currSum=prevSum+Math.abs(x-arr[right++])-Math.abs(x-arr[left++]);
            if(currSum<prevSum) {
                prevSum=currSum;
                finalLeft=left;
                finalRight=right-1;
            }
        }
        for(int i=finalLeft;i<=finalRight;i++)
            res.add(arr[i]);
        return res;
    }
}

// using binary search
// t.c.=O(log(n-k) + k), s.c.=O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int len=arr.length, left=0, right=len-k;
        List<Integer> res=new ArrayList<>();
        while(left<right) {
            int mid=left+(right-left)/2;
            if(x-arr[mid]>arr[mid+k]-x)
                left=mid+1;
            else
                right=mid;
        }
        for(int i=left;i<left+k;i++)
            res.add(arr[i]);
        return res;
    }
}
