// Using array
// t.c.=(n), s.c.=O(m), where n=total no of characters in the given array, m=total no of words in the array
class Solution {
    public List<String> commonChars(String[] words) {
        int n=words.length;
        List<String> ans = new ArrayList<>();
        int[][] count = new int[26][n];
        for(int i=0;i<n;i++) {
            String s = words[i];
            for(int j=0;j<s.length();j++) 
                count[s.charAt(j)-'a'][i]+=1;
        }
        for(int i=0;i<26;i++) {
            int min=Integer.MAX_VALUE;
            for(int j=0;j<n;j++) {
                min=Math.min(min, count[i][j]);
            }
            while(min>0) {
                ans.add(""+(char)('a'+i));
                min--;
            }
                
        }
        return ans;
    }
}
