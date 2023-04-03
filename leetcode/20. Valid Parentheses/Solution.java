// USing stack
// t.c.=O(n), s.c.=O(n)
class Solution {
    Map<Character, Character> mappings = new HashMap<>();
    public Solution() {
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length(); i++) {
            char c = s.charAt(i);
            if(mappings.containsKey(c)) {
                char topElement = stack.isEmpty()?'#':stack.pop();
                if(topElement!=mappings.get(c))
                    return false;
            }
            else
                stack.push(c);
        }
        return stack.isEmpty();
    }
}
