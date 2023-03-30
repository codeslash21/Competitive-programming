// Using linear scan
// t.c.=O(n), s.c.=O(1)
class Solution {
    private String findRange(int first, int second) {
        if(first==second)
            return String.valueOf(first);
        else
            return first+"->"+second;
    }
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int n=nums.length;
        List<String> list = new ArrayList<>();
        int prev=lower-1;
        for(int i=0;i<=n;i++) {
            int curr=i<n?nums[i]:upper+1;
            if(curr-prev>1)
                list.add(findRange(prev+1, curr-1));
            prev=curr;
        }
        return list;
    }
}
