// Using regular exppression
// t.c.=O(n), s.c.=O(n) where n is length of the array
class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        char[] arr = s.toCharArray();
        int len=arr.length;
        for(int i=0;i<len;i++)
            if(arr[i]-'A'<26)
                arr[i]=(char)('a'+arr[i]-'A');
        int start=0, end=len-1;
        while(start<end) {
            if(arr[start]!=arr[end]) 
                return false;
            start++;
            end--;
        }
        return true;
    }
}

// Without regular expression
// t.c.=O(n), s.c.=O(1)
class Solution {
    public boolean isPalindrome(String s) {
        for(int i=0, j=s.length()-1; i<j; i++, j--) {
            while(i<j && !Character.isLetterOrDigit(s.charAt(i)))
                i++;
            while(i<j && !Character.isLetterOrDigit(s.charAt(j)))
                j--;
            if(Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j)))
                return false;
        }
        return true;
    }
}

// Using stream functions
// t.c.=O(n), s.c.=O(1)
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder();
        s.chars()
            .filter(c->Character.isLetterOrDigit(c))
            .mapToObj(c->Character.toLowerCase((char)c))
            .forEach(builder::append);
        return builder.toString().equals(builder.reverse().toString());
    }
}
