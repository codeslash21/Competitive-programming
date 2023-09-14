// using bitmasking
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int[] singleNumber(int[] nums) {
        int xor=0;
        int xorP=0;
        for(int num:nums)
            xor^=num;
        int first=xor&(-xor);
        for(int num:nums) {
            if((num & first)>0)
                xorP^=num;
        }
        return new int[] {xorP, xor^xorP};
    }
}
