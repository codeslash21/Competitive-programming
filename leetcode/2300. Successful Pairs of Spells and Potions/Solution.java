// https://leetcode.com/problems/successful-pairs-of-spells-and-potions/description/
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int spellsLen=spells.length, potionsLen=potions.length, left=0, right=potionsLen-1;
        int[] pairs=new int[spellsLen];
        Arrays.sort(potions);
        for(int i=0;i<spellsLen;i++) {
            left=0; right=potionsLen-1;
            int spell=spells[i];
            while(left<=right) {
                int mid=left+(right-left)/2;
                if((long)spell*potions[mid]>=success) {
                    pairs[i]=potionsLen-mid;
                    right=mid-1;
                } else
                    left=mid+1;
            }
        }
        return pairs;
    }
}
