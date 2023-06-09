// using bruteforce method
// t.c.=O(n^2), s.c.=O(1)
class Solution {
    public boolean rotateString(String s, String goal) {
        int len1=s.length(), len2=goal.length();
        if(len1!=len2)
            return false;
        boolean res=false;
        for(int i=0;i<len1;i++) {
            String n = s.substring(i, len1)+s.substring(0,i);
            if(n.equals(goal)) {
                res=true;
                break;
            }
        }
        return res;
    }
}

// using KMP algorithm
// t.c.=O(n), s.c.=O(n)
class Solution {
    public boolean rotateString(String s, String goal) {
        int n=s.length();
        if(n!=goal.length())
            return false;
        int[] shifts = new int[n+1];
        Arrays.fill(shifts, 1);
        int left=-1;
        for(int right=0;right<n;right++) {
            while(left>=0 && goal.charAt(left)!=goal.charAt(right))
                left-=shifts[left];
            shifts[right+1] = right-left++;
        }
        int matchLen=0;
        for(char c:(s+s).toCharArray()) {
            while(matchLen>=0 && goal.charAt(matchLen)!=c)
                matchLen -= shifts[matchLen];
            if(++matchLen==n)
                return true;
        }
        return false;
    }
}
