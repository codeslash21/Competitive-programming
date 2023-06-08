class Solution {
    public int repeatedStringMatch(String a, String b) {
        int rpt = b.length()/a.length()+2;
        String A = a;
        for(int i=1;i<=rpt;i++) {
            if(A.contains(b))
                return i;
            A+=a;
        }
        return -1;
    }
}
