// Using greedy approach solvinf letter by letter
// t.c.=O(c*n), s.c.=O(c*n), c is the number of unique characters
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        int pos = 0;
        for(int i=0;i<s.length();i++)
            cnt[s.charAt(i)-'a']++;
        for(int i=0; i<s.length();i++) {
            if(s.charAt(i)<s.charAt(pos)) pos=i;
            if(--cnt[s.charAt(i)-'a']==0) break;
        }
        return s.length()==0?"":s.charAt(pos)+
            removeDuplicateLetters(s.substring(pos+1).replaceAll(""+s.charAt(pos),""));
    }
}

// Using grredy and stack
// t.c.=O(n), s.c.=O(1)
class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        HashSet<Character> seen = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++)
            map.put(s.charAt(i), i);
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(!seen.contains(c)) {
                while(!stack.isEmpty() && c<stack.peek() && map.get(stack.peek())>i)
                    seen.remove(stack.pop());
                seen.add(c);
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder(stack.size());
        for(Character c : stack)
            sb.append(c.charValue());
        return sb.toString();
    }
}
