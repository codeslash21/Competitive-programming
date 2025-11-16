// https://leetcode.com/problems/boats-to-save-people/description/
// Using sorting + two pointers
// t.c.=O(nlogn), s.c.=O(n)
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int len=people.length, left=0, right=len-1, cnt=0;
        Arrays.sort(people);
        while(left<=right) {
            if(people[left]+people[right--]<=limit)
                left++;
            cnt++;
        }
        return cnt;
    }
}
