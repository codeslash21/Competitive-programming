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
// t.c.=O(logn + k), s.c.=O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int left=0, n=arr.length, right=n-1;
        while(left<right) {
            int mid=(left+right)/2;
            if(arr[mid]>=x)
                right=mid;
            else
                left=mid+1;
        }
        left-=1;
        while(right-left<=k) {
            if(left==-1) {
                right++;
                continue;
            }
            if(right==n || Math.abs(arr[left]-x)<=Math.abs(arr[right]-x))
                left-=1;
            else
                right+=1;
        }
        for(int i=left+1; i<right; i++)
            res.add(arr[i]);
        return res;
    }
}
