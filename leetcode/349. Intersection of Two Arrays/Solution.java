// Using bruteforce method
// t.c.=O(n^2 + n.m), s.c.=O(n), n and m is the size of two arrays
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int len1=nums1.length, len2=nums2.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<len1;i++) {
            for(int j=0;j<len2;j++) {
                if(nums1[i]==nums2[j]) {
                    boolean flag=false;
                    for(int num:ans) {
                        if(num==nums1[i]) {
                            flag=true;
                            break;
                        }
                    }
                    if(!flag)
                        ans.add(nums1[i]);
                    break;
                }
            }
        }
        int[] res = new int[ans.size()];
        int i=0;
        for(int num:ans)
            res[i++]=num;
        return res;
    }
}

// Using hashmap and array
// t.c.=O(m+n), s.c.=O(m+n)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int len1=nums1.length, len2=nums2.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<len1;i++) 
            map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
        for(int i=0;i<len2;i++)
            if(map.getOrDefault(nums2[i], 0)>0) {
                ans.add(nums2[i]);
                map.put(nums2[i], 0);
            }
        int i=0;
        int[] res = new int[ans.size()];
        for(int num:ans)
            res[i++]=num;
        return res;
    }
}

// Using two sets
// t.c.=O(m+n), s.c.=O(m+n)
class Solution {
    public int[] interSection(HashSet<Integer> set1, HashSet<Integer> set2) {
        int[] output = new int[set1.size()];
        int idx=0;
        for(int n:set1)
            if(set2.contains(n))
                output[idx++]=n;
        return Arrays.copyOf(output, idx);
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        int len1=nums1.length, len2=nums2.length;
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(Integer num:nums1)
            set1.add(num);
        for(Integer num:nums2)
            set2.add(num);
        if(set1.size()<set2.size())
            return interSection(set1, set2);
        else
            return interSection(set2, set1);
    }
}
