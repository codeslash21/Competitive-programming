// https://leetcode.com/problems/isomorphic-strings/editorial/
// t.c.=O(n), s.c.=O(n)
class Solution {
    public static String transformString(String s) {
        Map<Character, Integer> indexMapping = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(!indexMapping.containsKey(ch))
                indexMapping.put(ch, i);
            sb.append(indexMapping.get(ch));
            sb.append(" ");
        }
        return sb.toString();
    }
    public boolean isIsomorphic(String s, String t) {
        return transformString(s).equals(transformString(t));
    }
}

// t.c.=O(n), s.c.=O(1)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int len=s.length();
        int[] mapStoT = new int[256];
        int[] mapTtoS = new int[256];
        Arrays.fill(mapStoT, -1);
        Arrays.fill(mapTtoS, -1);
        for(int i=0;i<len;i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if(mapStoT[ch1]==-1 && mapTtoS[ch2]==-1) {
                mapStoT[ch1]=ch2;
                mapTtoS[ch2]=ch1;
            } else if(!(mapStoT[ch1]==ch2))
                return false;
        }
        return true;
    }
}
