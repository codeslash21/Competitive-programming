// Using map and sorting
// t.c.=O(nlogn), s.c.=O(n)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums)
            map.put(num, map.getOrDefault(num, 0)+1);
        int[][] arr = new int[map.size()][2];
        int[] res = new int[k];
        int i=0;
        for(int num:map.keySet()) {
            arr[i][0]=num;
            arr[i][1]=map.get(num);
            i++;
        }
        Arrays.sort(arr, (a,b)->b[1]-a[1]);
        for(i=0;i<k;i++)
            res[i]=arr[i][0];
        return res;
    }
}

// Using map and heap
// t.c.=O(nlogk), s.c.=O(n+k)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a,b)->map.get(a)-map.get(b));
        int[] res = new int[k];
        for(int num:nums)
            map.put(num, map.getOrDefault(num, 0)+1);
        for(int num:map.keySet()) {
            heap.add(num);
            if(heap.size()>k)
                heap.poll();
        }
        for(int i=k-1;i>=0;i--)
            res[i]=heap.poll();
        return res;
    }
}
