// Using hashmap and counting
// t.c.=O(n+k), s.c.=O(n), k=range of the numbers
class Solution {
    public int lastStoneWeight(int[] stones) {
        int n=stones.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max=stones[0], min=stones[0];
        for(int i=0; i<n;i++) {
            map.put(stones[i], map.getOrDefault(stones[i], 0)+1);
            max=Math.max(max, stones[i]);
            min=Math.min(min, stones[i]);
        }
        int holding=0;
        int[] hold = new int[2];
        for(int val=max; val>=min; val--) {
            while(map.getOrDefault(val, 0)>0) {
                map.put(val, map.get(val)-1);
                hold[holding++]=val;
                if(holding==2) {
                    if(hold[0]!=hold[1]) {
                        int new_val=hold[0]-hold[1];
                        map.put(new_val, map.getOrDefault(new_val, 0)+1);
                        if(new_val>hold[1])
                            val=new_val+1;
                        else
                            min=Math.min(min, new_val);
                    }
                    holding=0;
                }
            }
        }
        return holding==0? 0:hold[0];
    }
}

// Using sorting
// t.c.=O(n^2), s.c.=O(1)
class Solution {
    public int lastStoneWeight(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        while(n>1) {
            if(nums[n-1]!=nums[n-2]) {
                int new_val=nums[n-1]-nums[n-2];
                int i=n-3;
                while(i>=0 && nums[i]>new_val) {
                    nums[i+1]=nums[i];
                    i--;
                }
                nums[i+1]=new_val;
                n--;
            }
            else
                n-=2;
        }
        return n==0? 0:nums[0];
    }
}

// using bruteforce
// t.c.=O(n^2), s.c.=(n)
class Solution {
    private int returnLargest(List<Integer> stones) {
        int indexOfMax=stones.indexOf(Collections.max(stones));
        int result = stones.get(indexOfMax);
        stones.set(indexOfMax, stones.get(stones.size()-1));
        stones.remove(stones.size()-1);
        return result;
    }
    public int lastStoneWeight(int[] stones) {
        List<Integer> stoneList = new ArrayList<>();
        for(int weight:stones)
            stoneList.add(weight);
        while(stoneList.size()>1) {
            int stone1 = returnLargest(stoneList);
            int stone2 = returnLargest(stoneList);
            if(stone1!=stone2)
                stoneList.add(stone1-stone2);
        }
        return stoneList.isEmpty()? 0:stoneList.remove(0);
    }
}

// Using min-heap / priority queue
// t.c.=O(nlogn), s.c.=O(n)
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone:stones)
            heap.add(stone);
        while(heap.size()>1) {
            int stone1=heap.remove();
            int stone2=heap.remove();
            if(stone1!=stone2)
                heap.add(stone1-stone2);
        }
        return heap.isEmpty()? 0:heap.remove();
    }
}
