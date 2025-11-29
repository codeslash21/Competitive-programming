// https://leetcode.com/problems/simplify-path/description/
// using stack
// t.c.=O(n), s.c.=O(n)
class Solution {
    public String simplifyPath(String path) {
        String[] dirs=path.split("/");
        Stack<String> stack=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(String dir:dirs) {
            if(dir.equals("..")) {
                if(!stack.isEmpty())
                    stack.pop();
            } else if(dir.equals(".") || dir.equals(""))
                continue;
            else
                stack.push("/"+dir);
        }
        for(String dir:stack)
            sb.append(dir);
        return stack.isEmpty()?"/":sb.toString();
    }
}
