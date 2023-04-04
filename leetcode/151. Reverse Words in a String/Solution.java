// Using built-in function
// t.c.=O(n), s.c.=O(n)
class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}

// Reverse whole string and then reverse each word
// t.c.=O(n), s.c.=O(n)
class Solution {
    public StringBuilder trim(String s) {
        int left=0, right=s.length()-1;
        while(left<=right && s.charAt(left)==' ') left++;
        while(left<=right && s.charAt(right)==' ') right--;
        StringBuilder sb = new StringBuilder();
        while(left<=right) {
            char c = s.charAt(left);
            if(c!=' ')
                sb.append(c);
            else if(sb.charAt(sb.length()-1)!=' ')
                sb.append(c);
            left++;
        }
        return sb;
    }
    public void reverse(StringBuilder sb, int start, int end) {
        while(start<end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start++, sb.charAt(end));
            sb.setCharAt(end--, temp);
        }
    }
    public void reverseEachWord(StringBuilder sb) {
        int left=0, right=0, n=sb.length();
        while(left<n) {
            while(right<n && sb.charAt(right)!=' ') right++;
            reverse(sb, left, right-1);
            right++;
            left=right;
        }
    }
    public String reverseWords(String s) {
        StringBuilder sb = trim(s);
        reverse(sb, 0, sb.length()-1);
        reverseEachWord(sb);
        return sb.toString();
    }
}

// Using deque
// t.c.=O(n), s.c.=O(n)
class Solution {
    public String reverseWords(String s) {
        int left=0, right=s.length()-1;
        while(left<=right && s.charAt(left)==' ') left++;
        while(left<=right && s.charAt(right)==' ') right--;
        Deque<String> d = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        while(left<=right) {
            char c = s.charAt(left);
            if(sb.length()!=0 && c==' ') {
                d.offerFirst(sb.toString());
                sb.setLength(0);
            }
            else if(c!=' ')
                sb.append(c);
            left++;
        }
        d.offerFirst(sb.toString());
        return String.join(" ", d);
    }
}
