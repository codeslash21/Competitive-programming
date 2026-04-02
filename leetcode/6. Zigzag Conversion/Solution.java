// https://leetcode.com/problems/zigzag-conversion/description/
// t.c.=O(n+k), s.c.=O(n+k)
class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1)
            return s;
        int len=s.length(), step=1, bucketIdx=0;
        StringBuilder sb=new StringBuilder();
        List<Character>[] buckets=new ArrayList[numRows];
        for(int i=0;i<numRows;i++)
            buckets[i]=new ArrayList<Character>();
        for(int i=0;i<len;i++) {
            buckets[bucketIdx].add(s.charAt(i));
            if(bucketIdx==0)
                step=1;
            else if(bucketIdx==numRows-1)
                step=-1;
            bucketIdx+=step;
        }
        for(List<Character> list:buckets)
            for(Character ch:list)
                sb.append(ch);
        return sb.toString();
    }
}

// t.c.=O(n), s.c.=O(1)
class Solution {
    public String convert(String s, int numRows) {
        int len=s.length(), cycleSize=2*numRows-2;
        if(numRows==1 || numRows>=len)
            return s;
        StringBuilder sb=new StringBuilder();
        for(int row=0;row<numRows;row++) {
            for(int cycleStart=0;cycleStart+row<len;cycleStart+=cycleSize) {
                // append character for downward leg
                sb.append(s.charAt(cycleStart+row));
                // append character for upward leg
                if(row>0 && row<numRows-1 && cycleStart+cycleSize-row<len)
                    sb.append(s.charAt(cycleStart+cycleSize-row));
            }
        }
        return sb.toString();
    }
}
