// Using stack
// t.c.=O(maxK^countK * n), s.c.=O(maxK^countK * n), where maxK is the maximum value of K and countK is the number of K, and n is the max length of encoded string
class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)==']') {
                List<Character> decodedString = new ArrayList<>();
                while(stack.peek()!='[') 
                    decodedString.add(stack.pop());
                stack.pop();
                int base=1;
                int k=0;
                while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    k=k+(stack.pop()-'0')*base;
                    base*=10;
                }
                while(k--!=0)
                    for(int j=decodedString.size()-1;j>=0;j--)
                        stack.push(decodedString.get(j)); 
            }
            else 
                stack.push(s.charAt(i));
        }
        char[] result = new char[stack.size()];
        for(int i=result.length-1;i>=0;i--)
            result[i]=stack.pop();
        return new String(result);
    }
}

// using two stack
// t.c.=O(maxK*n), s.c.=O(m+n) where m is the number of letter in the final decoded string
class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currString = new StringBuilder();
        int k=0;
        for(char c:s.toCharArray()) {
            if(Character.isDigit(c))
                k=k*10+c-'0';
            else if(c=='[') {
                countStack.push(k);
                stringStack.push(currString);
                currString=new StringBuilder();
                k=0;
            }
            else if(c==']') {
                StringBuilder decode = stringStack.pop();
                for(int i=countStack.pop();i>0;i--)
                    decode.append(currString);
                currString = decode;
            }
            else 
                currString.append(c);
        }
        return currString.toString();
    }
}

// using recursion
// t.c.=O(maxK*n), s.c.=O(n), where n is the length of s and maxK is the max value of k
class Solution {
    int index=0;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        while(index<s.length() && s.charAt(index)!=']') {
            if(!Character.isDigit(s.charAt(index)))
                sb.append(s.charAt(index++));
            else {
                int k=0;
                while(index<s.length() && Character.isDigit(s.charAt(index)))
                    k=k*10+s.charAt(index++)-'0';
                index++;
                String decodedString = decodeString(s);
                index++;
                while(k-->0)
                    sb.append(decodedString);
            }
        }
        return new String(sb);
    }
}
