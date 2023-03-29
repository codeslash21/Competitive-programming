// Using sliding window
// t.c.=O(s+t), s.c.=O(s+t) when sliding window size will be the length of the string S and all the characters in string T are unique
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> dictT = new HashMap<>();
        for(int i=0;i<t.length();i++) 
            dictT.put(t.charAt(i), dictT.getOrDefault(t.charAt(i), 0)+1);
        int required=dictT.size();
        int formed=0;
        Map<Character, Integer> dictS = new HashMap<>();
        int l=0,r=0;
        int[] ans = {-1, 0, 0};
        while(r<s.length()) {
            char curr=s.charAt(r);
            dictS.put(curr, dictS.getOrDefault(curr, 0)+1);
            if(dictT.containsKey(curr) && dictS.get(curr).intValue()==dictT.get(curr).intValue())
                formed++;
            while(l<=r && formed==required) {
                char lChar = s.charAt(l);
                if(ans[0]==-1 || ans[0]>(r-l+1)) {
                    ans[0]=r-l+1;
                    ans[1]=l;
                    ans[2]=r;
                }
                dictS.put(lChar, dictS.get(lChar)-1);
                if(dictT.containsKey(lChar) && dictT.get(lChar).intValue()>dictS.get(lChar).intValue())
                    formed--;
                l++;
            }
            r++;
        }
        return ans[0]==-1? "" : s.substring(ans[1], ans[2]+1);
    }
}

// Optimized sliding window by filtering the main characters which are in T
// t.c.=O(s+t), s.c.=O(s+t)
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> dictT = new HashMap<>();
        for(int i=0;i<t.length();i++) 
            dictT.put(t.charAt(i), dictT.getOrDefault(t.charAt(i), 0)+1);
        List<Pair<Integer, Character>> filteredS = new ArrayList<Pair<Integer, Character>>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(dictT.containsKey(c))
                filteredS.add(new Pair<Integer, Character>(i, c));
        }
        int required=dictT.size();
        int formed=0;
        Map<Character, Integer> dictS = new HashMap<>();
        int l=0,r=0;
        int[] ans = {-1, 0, 0};
        while(r<filteredS.size()) {
            char curr=filteredS.get(r).getValue();
            dictS.put(curr, dictS.getOrDefault(curr, 0)+1);
            if(dictS.get(curr).intValue()==dictT.get(curr).intValue())
                formed++;
            while(l<=r && formed==required) {
                int start=filteredS.get(l).getKey();
                int end=filteredS.get(r).getKey();
                if(ans[0]==-1 || ans[0]>(end-start+1)) {
                    ans[0]=end-start+1;
                    ans[1]=start;
                    ans[2]=end;
                }
                char lChar=filteredS.get(l).getValue();
                dictS.put(lChar, dictS.get(lChar)-1);
                if(dictT.get(lChar).intValue()>dictS.get(lChar).intValue())
                    formed--;
                l++;
            }
            r++;
        }
        return ans[0]==-1? "" : s.substring(ans[1], ans[2]+1);
    }
}
