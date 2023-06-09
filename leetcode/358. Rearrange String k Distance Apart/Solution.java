// greedy approach
// t.c.=O(n^2), s.c.=O(1)
class Solution {
    public String rearrangeString(String s, int k) {
        int n=s.length();
        int[] freq = new int[26], validPos = new int[26];
        for(int i=0;i<n;i++)
            freq[s.charAt(i)-'a']++;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            int candidatePos = findValidMax(freq, validPos, i);
            if(candidatePos==-1)
                return "";
            freq[candidatePos]--;
            validPos[candidatePos]=i+k;
            sb.append((char)('a'+candidatePos));
        }
        return sb.toString();
    }
    private int findValidMax(int[] freq, int[] validPos, int idx) {
        int max=Integer.MIN_VALUE, candidatePos=-1;
        for(int i=0; i<freq.length; i++) {
            if(freq[i]>0 && freq[i]>max && idx>=validPos[i]) {
                max=freq[i];
                candidatePos=i;
            }
        }
        return candidatePos;
    }
}
