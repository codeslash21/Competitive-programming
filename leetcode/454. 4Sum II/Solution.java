// Using hashmap
// t.c.=O(n^2), s.c.=O(n^2)
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int cnt=0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int a:nums1)
            for(int b:nums2)
                map.put(a+b, map.getOrDefault(a+b, 0)+1);
        for(int c:nums3)
            for(int d:nums4)
                cnt+=map.getOrDefault(-(c+d), 0);
        return cnt;
    }
}

// Genralising the above solution
// t.c.=O(n^2), s.c.=O(n^2)
class Solution {
    public Map<Integer,Integer> countSum(int[][] lists, int start, int end) {
        Map<Integer, Integer> cnt = new HashMap<>();
        cnt.put(0, 1);
        for(int i=start; i<end; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int a:lists[i])
                for(int total:cnt.keySet())
                    map.put(total+a, map.getOrDefault(total+a, 0)+cnt.get(total));
            cnt=map;
        }
        return cnt;
    }
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int cnt=0;
        int[][] lists = new int[][] {nums1, nums2, nums3, nums4};
        int k=lists.length;
        Map<Integer, Integer> left = countSum(lists, 0, k/2);
        Map<Integer,Integer> right = countSum(lists, k/2, k);
        for(int s:left.keySet())
            cnt+=left.get(s)*right.getOrDefault(-s, 0);
        return cnt;
    }
}
