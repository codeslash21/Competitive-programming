// Using sorting
// t.c.=O(logn), s.c.=O(1)
class Solution {
    public int thirdMax(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int find=1, prev=nums[n-1];
        for(int i=n-2;i>=0;i--) {
            if(nums[i]!=prev) {
                find++;
                prev=nums[i];
            }
            if(find==3)
                return prev;
        }
        return nums[n-1];
    }
}

// Using priorityqueue and set
// t.c.=O(n), s.c.=O(1), as priorityQueue and set both can have max 3 elements
class Solution {
    public int thirdMax(int[] nums) {
        int n = nums.length;
        PriorityQueue<Integer> minHeap= new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++) {
            if(set.contains(nums[i]))
                continue;
            minHeap.add(nums[i]);
            set.add(nums[i]);
            if(minHeap.size()>3)
                set.remove(minHeap.poll());
        }
        if(minHeap.size()==2) 
            minHeap.poll();
        return minHeap.peek();
    }
}

// Using ordered set or TreeSet
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> sortedNums = new TreeSet<>();
        for(int num:nums) {
            if(sortedNums.contains(num))
                continue;
            sortedNums.add(num);
            if(sortedNums.size()>3) 
                sortedNums.pollFirst();
        }
        if(sortedNums.size()==2)
            return sortedNums.last();
        return sortedNums.first();
    }
}

// using three pointers
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int thirdMax(int[] nums) {
        long first=Long.MIN_VALUE, second=Long.MIN_VALUE, third=Long.MIN_VALUE;
        for(int num:nums) {
            if(first==num || second==num || third==num)
                continue;
            if(num>first) {
                third=second;
                second=first;
                first=num;
            }
            else if(num>second) {
                third=second;
                second=num;
            }
            else if(num>third)
                third=num;
        }
        if(third==Long.MIN_VALUE)
            return (int)first;
        return (int)third;
    }
}

// Using three pointer second approach if Long is not supported
// t.c.=O(n), s.c.=O(1)

class Solution {
    public int thirdMax(int[] nums) {
        Pair<Integer, Boolean> first = new Pair<Integer, Boolean>(-1, false);
        Pair<Integer, Boolean> second = new Pair<Integer, Boolean>(-1, false);
        Pair<Integer, Boolean> third = new Pair<Integer, Boolean>(-1, false);
        for(int num:nums) {
            if((first.getValue() && first.getKey()==num) ||
                (second.getValue() && second.getKey()==num) ||
                (third.getValue() && third.getKey()==num))
                continue;
            if(!first.getValue() || first.getKey()<num) {
                third=second;
                second=first;
                first=new Pair<Integer, Boolean>(num, true);
            }
            else if(!second.getValue() || second.getKey()<num) {
                third=second;
                second=new Pair<Integer, Boolean>(num, true);
            }
            else if(!third.getValue() || third.getKey()<num)
                third=new Pair<Integer, Boolean>(num, true);
        }
        if(!third.getValue())
            return first.getKey();
        return third.getKey();
    }
}
