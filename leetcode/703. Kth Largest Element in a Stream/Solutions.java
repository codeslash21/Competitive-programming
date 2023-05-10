// Using arraylist
class KthLargest {
    List<Integer> list;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        list = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++)
            list.add(nums[i]);
        Collections.sort(list);
        if(list.size()>k) {
            while(list.size()!=k)
                list.remove(0);
        }
    }
    public int findIndex(int val) {
        int l=0, r=k-1;
        while(l<r) {
            int mid=(l+r)/2;
            if(list.get(mid)>val)
                r=mid;
            else
                l=mid+1;
        }
        return l;
    }
    public int add(int val) {
        if(list.size()!=0 && val<=list.get(0))
            list.add(0, val);
        else if(list.size()==0 || val>=list.get(list.size()-1))
            list.add(val);
        else {
            int idx = findIndex(val);
            list.add(idx, val);
        }
        if(list.size()>k)
            list.remove(0);
        return list.get(0);
    }
}

// Using heap
// t.c.=O(nlogn+mlogk), s.c.=O(n)
class KthLargest {
    PriorityQueue<Integer> heap;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<Integer>();
        for(int num:nums)
            heap.offer(num);
        while(heap.size()>k)
            heap.poll();
    }
    public int add(int val) {
        heap.offer(val);
        if(heap.size()>k)
            heap.poll();
        return heap.peek();
    }
}
