// Using hash map
class Solution {
    public String toLowerCase(String s) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        Map<Character, Character> h = new HashMap();
        for(int i=0;i<26;i++)
            h.put(upper.charAt(i), lower.charAt(i));
        StringBuilder sb = new StringBuilder();
        for(char x : s.toCharArray())
            sb.append(h.containsKey(x)? h.get(x) : x);
        return sb.toString();
    }
}

// Using ascii value
class Solution {
    public boolean isUpper(char x) {
        return 'A'<=x && x<='Z';
    }
    public char toLower(char x) {
        return (char) ((int)x | 32);
    }
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for(char x : s.toCharArray())
            sb.append(isUpper(x)? toLower(x) : x);
        return sb.toString();
    }
}

// t.c. = O(n)
// s.c. = O(n), for creating a new string
