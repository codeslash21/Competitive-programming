// Using two sum approach for each of the array element
// t.c.=O(n^2), s.c.=O(1), except for sorting
class Solution {
    public void findTarget(int[] nums, int start, int end, int target, List<List<Integer>> res) {
        while(start<end) {
            if((nums[start]+nums[end])==target) {
                res.add(Arrays.asList(-1*target, nums[start++], nums[end--]));
                while(start<end && nums[start]==nums[start-1])
                    start++;
            }
            else if((nums[start]+nums[end])>target)
                end--;
            else
                start++;
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++) {
            if(nums[i]>0)
                break;
            if(i==0 || nums[i]!=nums[i-1])
                findTarget(nums, i+1, n-1, -1*nums[i], res);
        }
        return res;
    }
}

// Using hashset and complement
// t.c.=O(n^2) ,s.c.=O(n) for hashset
class Solution {
    public void findTarget(int[] nums, int start, int end, int target, List<List<Integer>> res) {
        HashSet<Integer> seen = new HashSet<>();
        for(int i=start;i<=end;i++) {
            int complement = target-nums[i];
            if(seen.contains(complement)) {
                res.add(Arrays.asList(-1*target, nums[i], complement));
                while(i+1<=end && nums[i]==nums[i+1])
                    i++;
            }
            seen.add(nums[i]);
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++) {
            if(nums[i]>0)
                break;
            if(i==0 || nums[i]!=nums[i-1])
                findTarget(nums, i+1, n-1, -1*nums[i], res);
        }
        return res;
    }
}

// Without using sorting
// t.c.=O(n^2), s.c.=O(n)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len=nums.length;
        Set<Integer> duplicate1=new HashSet<>(), seen=new HashSet<>();
        Set<List<Integer>> res=new HashSet<>();
        for(int i=0;i<len-2;i++) {
            if(duplicate1.add(nums[i]))
                for(int j=i+1;j<len;j++) {
                    int complement=-nums[i]-nums[j];
                    if(seen.contains(complement)) {
                        List<Integer> triplet=Arrays.asList(nums[i], nums[j], complement);
                        Collections.sort(triplet);
                        res.add(triplet);
                    }
                    seen.add(nums[j]);
                }
            seen.clear();   
        }
        return new ArrayList(res);
    }
}
