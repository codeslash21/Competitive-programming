// Using modified boyer moore algorithm
// t.c.=O(n), s.c.=O(1)
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cnt1=0, cnt2=0;
        Integer candidate1=null, candidate2=null;
        for(int n:nums) {
            if(candidate1!=null && candidate1==n)
                cnt1++;
            else if(candidate2!=null && candidate2==n)
                cnt2++;
            else if(cnt1==0) {
                candidate1=n;
                cnt1++;
            } else if(cnt2==0) {
                candidate2=n;
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        List<Integer> result=new ArrayList<>();
        cnt1=0; cnt2=0;
        for(int n:nums) {
            if(candidate1!=null && candidate1==n)   cnt1++;
            if(candidate2!=null && candidate2==n)   cnt2++;
        }
        int n=nums.length;
        if(cnt1>n/3)    result.add(candidate1);
        if(cnt2>n/3)    result.add(candidate2);
        return result;
    }
}
