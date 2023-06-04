// Using binary search 
// t.c.=O(n*k), s.c.=O(k)
class Solution {
    private int findPosition(List<Integer> nums, int start, int end, int target) {
        int idx=0, size=nums.size();
        while(start<=end) {
            int mid=(start+end)/2;
            if(mid<size && nums.get(mid)>=target) {
                idx=mid;
                end=mid-1;
            }
            else
                start=mid+1;
        }
        return start>=size?-1:idx;
    }
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length, j=0;
        double[] res = new double[n-k+1];
        List<Integer> window = new ArrayList<>();
        for(int i=0;i<k-1;i++)
            window.add(nums[i]);
        Collections.sort(window);
        for(int i=0;i<n-k+1;i++) {
            int ele = nums[i+k-1];
            int idx = findPosition(window, 0, k-1, ele);
            if(idx==-1)
                window.add(ele);
            else
                window.add(idx, ele);
            if(k%2==1) 
                res[j++]=(double)window.get(k/2);
            else
                res[j++]=((double)window.get(k/2)+(double)window.get(k/2-1))/2;
            window.remove(Integer.valueOf(nums[i]));
        }
        return res;
    }
}
