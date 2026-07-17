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

// using rabin-karp algo
// t.c.=O(n+m), s.c.=O(1), n=len(a), m=len(b)
class Solution {
    private long base=26, mod=1_000_000_007, power=1;
    private long hashA, hashB;
    private int n,m;
    public int repeatedStringMatch(String a, String b) {
        n=a.length(); m=b.length();
        // check every char in b present in a
        if(!charOfBPresentInA(a, b))    return -1;
        // calculate hash of b
        for(int i=0;i<m;i++) {
            hashB=(hashB * base + (b.charAt(i)-'a'))%mod;
            power=(power*base)%mod;
        }
        for(int i=0;i<m-1;i++)
            hashA=(hashA * base + (a.charAt(i%n)-'a')) % mod;
        for(int i=0;i<n;i++)
            if(findMatch(a, b, i))
                return (int)Math.ceil((double)(i+m)/n);
        return -1;
    }
    private boolean charOfBPresentInA(String a, String b) {
        boolean[] charInA=new boolean[26];
        for(char ch:a.toCharArray())
            charInA[ch-'a']=true;
        for(char ch:b.toCharArray())
            if(!charInA[ch-'a'])    return false;
        return true;
    }
    private boolean findMatch(String a, String b, int idx) {
        hashA=(hashA * base 
            - (idx>0?(a.charAt(idx-1)-'a')*power:0) // subtract contribution of excluded char
            + (a.charAt((idx+m-1)%n)-'a')) % mod;   // add contribution of included char
        if(hashA!=hashB)    return false;
        for(int i=idx;i<idx+m;i++)
            if(a.charAt(i%n)!=b.charAt(i-idx))  return false;
        return true;
    }
}
