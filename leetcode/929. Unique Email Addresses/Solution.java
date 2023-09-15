// Using builtin functions
// t.c.=O(n*m), s.c.=O(n*m) where n is the number of the strings and m is the max length of string
class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(String email:emails) {
            String[] parts = email.split("@");
            String[] local = parts[0].split("\\+");
            set.add(local[0].replace(".", "")+"@"+parts[1]);
        }
        return set.size();
    }
}
