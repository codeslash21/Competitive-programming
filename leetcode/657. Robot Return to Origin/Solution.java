// https://leetcode.com/problems/robot-return-to-origin/description/
// t.c.=O(n), s.c.=O(1)
class Solution {
    public boolean judgeCircle(String moves) {
        int vertical=0, horizontal=0;
        for(char move:moves.toCharArray()) {
            switch(move) {
                case 'U':
                    vertical++;
                    break;
                case 'D':
                    vertical--;
                    break;
                case 'L':
                    horizontal--;
                    break;
                case 'R':
                    horizontal++;
                    break;
            }
        }
        return vertical==0 && horizontal==0;
    }
}
