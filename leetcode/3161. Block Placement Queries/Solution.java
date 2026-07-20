// https://leetcode.com/problems/block-placement-queries/description/
// using sorted set
// t.c.=O(n^2), s.c.=O(n)
class Solution {
    public List<Boolean> getResults(int[][] queries) {
        TreeSet<Integer> obstacles=new TreeSet<>();
        List<Boolean> result=new ArrayList<>();
        for(int[] query:queries) {
            int type=query[0];
            if(type==1)
                obstacles.add(query[1]);
            else {
                int x=query[1], sz=query[2], prevPos=0;
                boolean canPlace=false;
                for(int obstacle:obstacles) {
                    if(obstacle>x)  break;
                    if(obstacle-prevPos>=sz) {
                        canPlace=true;
                        break;
                    }
                    prevPos=obstacle;
                }
                // Check gap from last obstacle to x
                if(!canPlace && (x-prevPos)>=sz)
                    canPlace=true;
                result.add(canPlace);
            }
        }
        return result;
    }
}
