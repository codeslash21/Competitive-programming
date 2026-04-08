// https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/
// brute force
// O((n - totalLen)*m*w), s.c.=O(m*w), n=len(s), m=len(words), w=len(words[0])
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int wordsLen=words.length, wordLen=words[0].length(), strLen=s.length();
        int totalLen=wordsLen*wordLen;
        List<Integer> res=new ArrayList<>();
        Map<String, Integer> wordFreq=new HashMap<>();
        if(strLen<totalLen)
            return res;
        for(String word:words)
            wordFreq.put(word, wordFreq.getOrDefault(word, 0)+1);
        for(int i=0;i<=strLen-totalLen;i++) {
            Map<String, Integer> wordSeen=new HashMap<>();
            boolean valid=true;
            for(int j=0;j<wordsLen;j++) {
                String chunk=s.substring(i+j*wordLen, i+j*wordLen+wordLen);
                wordSeen.put(chunk, wordSeen.getOrDefault(chunk, 0)+1);
                if(wordSeen.get(chunk)>wordFreq.getOrDefault(chunk, 0)) {
                    valid=false;
                    break;
                }
            }
            if(valid)
                res.add(i);
        }
        return res;
    }
}

// using sliding window
// t.c.=O(n*w), s.c.=O(m*w)
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int wordsLen=words.length, wordLen=words[0].length(), strLen=s.length();
        int totalLen=wordsLen*wordLen;
        List<Integer> res=new ArrayList<>();
        Map<String, Integer> wordFreq=new HashMap<>();
        if(strLen<totalLen)
            return res;
        for(String word:words)
            wordFreq.put(word, wordFreq.getOrDefault(word, 0)+1);
        int distinctWords=wordFreq.size();
        for(int i=0;i<wordLen;i++) {
            Map<String, Integer> seenWord=new HashMap<>();
            int match=0, left=i;
            for(int right=i;right+wordLen<=strLen;right+=wordLen) {
                String rightWord=s.substring(right, right+wordLen);
                if(wordFreq.containsKey(rightWord)) {
                    int count=seenWord.merge(rightWord, 1, Integer::sum);
                    if(count==wordFreq.get(rightWord))
                        match++;
                    else if(count==wordFreq.get(rightWord)+1)
                        match--;
                } 
                if(right-left>=totalLen) {
                    String leftWord=s.substring(left, left+wordLen);
                    if(wordFreq.containsKey(leftWord)) {
                        int count=seenWord.get(leftWord);
                        if(count==wordFreq.get(leftWord))
                            match--;
                        else if(count==wordFreq.get(leftWord)+1)
                            match++;
                        seenWord.put(leftWord, count-1);
                    }
                    left+=wordLen;
                }
                if(match==distinctWords)
                    res.add(left);
            }
        }
        return res;
    }
}
