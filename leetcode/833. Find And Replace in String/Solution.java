// Using peice table concepts
// t.c.=O(n+k*l), s.c.=O(length new string) where l is the avg length of each target string and n is the length of original string
class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer, Integer> table = new HashMap<>();
        for(int i=0;i<indices.length;i++)       
            if(s.startsWith(sources[i], indices[i]))
                table.put(indices[i], i);
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<s.length();) {
            if(table.containsKey(i)){
                builder.append(targets[table.get(i)]);
                i+=sources[table.get(i)].length();
            }
            else {
                builder.append(s.charAt(i));
                i++;
            }
        }
        return builder.toString();
    }
}
