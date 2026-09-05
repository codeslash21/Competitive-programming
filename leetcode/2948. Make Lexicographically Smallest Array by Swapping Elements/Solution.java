// https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/description
// using sorting and greedy
// t.c.=O(nlogn), s.c.=O(n)
class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int len=nums.length, currGroupId=0;
        int[] sortedNums=new int[len];
        Map<Integer, Integer> numToGroup=new HashMap<>();
        Map<Integer, Queue<Integer>> groupToNums=new HashMap<>();
        for(int i=0;i<len;i++)  sortedNums[i]=nums[i];
        Arrays.sort(sortedNums);
        groupToNums.computeIfAbsent(currGroupId, k -> new LinkedList<>()).add(sortedNums[0]);
        numToGroup.put(sortedNums[0], currGroupId);
        for(int i=1;i<len;i++) {
            if(sortedNums[i]-sortedNums[i-1]>limit)
                currGroupId++;
            numToGroup.put(sortedNums[i], currGroupId);
            groupToNums.computeIfAbsent(currGroupId, k -> new LinkedList<>()).add(sortedNums[i]);
        }
        for(int i=0;i<len;i++) {
            int group=numToGroup.get(nums[i]);
            nums[i]=groupToNums.get(group).poll();
        }
        return nums;
    }
}
