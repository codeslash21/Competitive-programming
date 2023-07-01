// t.c.=O(max(m,n)), s.c.=O(max(m,n))
class Solution {
    public String addBinary(String a, String b) {
        int m=a.length(), n=b.length();
        if(m<n)
            return addBinary(b,a);
        StringBuilder sb = new StringBuilder();
        int carry=0;
        for(int i=m-1;i>=0;i--) {
            if(a.charAt(i)=='1')
                carry++;
            if(--n>=0 && b.charAt(n)=='1')
                carry++;
            if(carry%2==1)
                sb.append('1');
            else
                sb.append('0');
            carry=carry/2;
        }
        if(carry>0)
            sb.append('1');
        return sb.reverse().toString();
    }
}
