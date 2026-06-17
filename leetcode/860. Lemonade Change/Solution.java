// https://leetcode.com/problems/lemonade-change/description/
// using iteration
// t.c.=O(n),s.c.=O(1)
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveCnt=0, tenCnt=0;
        for(int bill:bills) {
            if(bill==5)
                fiveCnt++;
            else if(bill==10) {
                fiveCnt--;
                tenCnt++;
            } else if(tenCnt>0) {
                tenCnt--;
                fiveCnt--;
            } else
                fiveCnt-=3;
            if(fiveCnt<0)
                return false;
        }
        return true;
    }
}
