// https://leetcode.com/problems/crawler-log-folder/description/
// using counter
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int minOperations(String[] logs) {
        int cnt=0;
        for(String log:logs) {
            if(log.equals("../"))
                cnt-=cnt>0?1:0;
            else if(!log.equals("./"))
                cnt++;
        }
        return cnt;
    }
}
