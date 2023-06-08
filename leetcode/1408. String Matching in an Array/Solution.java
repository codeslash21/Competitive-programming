// bruteforce method and set
// t.c.=O(n*n*k), s.c.=O(1)
class Solution {
    public List<String> stringMatching(String[] words) {
        Set<String> res = new HashSet<>();
        int n=words.length;
        for(int i=0;i<n;i++) 
            for(int j=i+1; j<n; j++)
                if(words[i].contains(words[j]))
                    res.add(words[j]);
                else if(words[j].contains(words[i]))
                    res.add(words[i]);
        return new ArrayList(res);
    }
}

