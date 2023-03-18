// merge sort
// t.c.=O(nlogn), s.c.=O(1)
class Solution {
    public void merge(int[] nums, int p, int q, int r) {
        int n1=q-p+1;
        int n2=r-q;
        int[] left=new int[n1+1];
        int[] right=new int[n2+1];
        for(int i=0;i<n1;i++)
            left[i]=nums[p+i];
        left[n1]=Integer.MAX_VALUE;
        for(int i=0;i<n2;i++)
            right[i]=nums[q+i+1];
        right[n2]=Integer.MAX_VALUE;
        int i=0, j=0;
        for(int k=p;k<=r;k++)
            if(left[i]<=right[j])
                nums[k]=left[i++];
            else
                nums[k]=right[j++];
    }
    public void mergeSort(int[] nums, int p, int r) {
        if(p<r) {
            int q=(p+r)/2;
            mergeSort(nums, p, q);
            mergeSort(nums, q+1, r);
            merge(nums, p, q, r);
        }
    }
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }
}

// Counting sort
// t.c.=O(n+k), s.c.=O(k) where k is the range of the array elements
class Solution {
    public void countingSort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n=nums.length;
        int max=nums[0], min=nums[0];
        for(int i=0;i<n;i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            max=Math.max(max, nums[i]);
            min=Math.min(min, nums[i]);
        }
        int index=0;
        for(int val=min; val<=max; val++) {
            while(map.getOrDefault(val, 0) > 0) {
                nums[index++]=val;
                map.put(val, map.get(val)-1);
            }
        }
    }
    public int[] sortArray(int[] nums) {
        countingSort(nums);
        return nums;
    }
}

// heap sort
// t.c.=O(nlogn), s.c.=O(logn)
class Solution {
    public void swap(int[] nums, int index1, int index2) {
        int temp=nums[index1];
        nums[index1]=nums[index2];
        nums[index2]=temp;
    }
    public void heapify(int[] nums, int n, int i) {
        int largest=i;
        int left=i*2+1;
        int right=i*2+2;
        if(left<n && nums[left]>nums[i])
            largest=left;
        if(right<n && nums[right]>nums[largest])
            largest=right;
        if(largest!=i) {
            swap(nums, i, largest);
            heapify(nums, n, largest);
        }
    }
    public void buildMaxHeap(int[] nums, int n) {
        for(int i=n/2-1; i>=0; i--)
            heapify(nums, n, i);
    }
    public void heapSort(int[] nums) {
        int n=nums.length;
        buildMaxHeap(nums, n);
        for(int i=n-1; i>0; i--) {
            swap(nums, i, 0);
            heapify(nums, i, 0);
        }
    }
    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }
}
