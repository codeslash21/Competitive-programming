// Using heap/priority queue
// t.c.=O(nlogk), s.c.=O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2)->n1-n2);
        for(int n:nums) {
            heap.add(n);
            if(heap.size()>k)
                heap.poll();
        }
        return heap.poll();
    }
}

// Using quick sort technique
// t.c.=O(n0 in avg case, O(n^2) in worst case, s.c.=O(1)
class Solution {
    int[] nums;
    public void swap(int a, int b) {
        int temp = this.nums[a];
        this.nums[a]=this.nums[b];
        this.nums[b]=temp;
    }
    public int partition(int left, int right, int pivot_idx) {
        int pivot = this.nums[pivot_idx];
        swap(pivot_idx, right);
        int store_idx = left;
        for(int i=left;i<=right;i++) {
            if(this.nums[i]<pivot) {
                swap(store_idx, i);
                store_idx++;
            }
        }
        swap(store_idx, right);
        return store_idx;
    }
    public int quickSelect(int left, int right, int index) {
        if(left==right)
            return this.nums[left];
        Random randInt = new Random();
        int pivot_idx = left + randInt.nextInt(right-left);
        pivot_idx = partition(left, right, pivot_idx);
        if(pivot_idx==index)
            return this.nums[pivot_idx];
        else if(pivot_idx>index)
            return quickSelect(left, pivot_idx-1, index);
        return quickSelect(pivot_idx+1, right, index);
    }
    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        int n=nums.length;
        return quickSelect(0, n-1, n-k);
    }
}
