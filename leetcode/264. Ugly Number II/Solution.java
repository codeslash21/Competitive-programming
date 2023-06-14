// Using minheap and set
// t.c.=O(nlogn), s.c.=O(n)
class Solution {
    public int nthUglyNumber(int n) {
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        int[] mul = {2,3,5};
        set.add((long)1);
        minHeap.offer((long)1);
        long ans=1, val=1;
        while(n-->0) {
            ans=minHeap.poll();
            for(int num:mul) {
                val=ans*num;
                if(!set.contains(val)){
                    minHeap.offer(val);
                    set.add(val);
                }
            }
        }
        return (int)ans;
    }
}

// using array
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        Set<Integer> set = new HashSet<>();
        ugly[0]=1;
        int p2=0, p3=0, p5=0;
        for(int i=1;i<n;i++) {
            int val = Math.min(ugly[p2]*2, Math.min(ugly[p3]*3, ugly[p5]*5));
            if(!set.contains(val)) {
                ugly[i]=val;
                set.add(val);
            }
            else
                i--;
            if(val==ugly[p2]*2)
                p2++;
            else if(val==ugly[p3]*3)
                p3++;
            else
                p5++;
        }
        return ugly[n-1];
    }
}
