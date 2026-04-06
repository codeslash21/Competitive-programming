// https://leetcode.com/problems/number-of-matching-subsequences/description/
// t.c.=O(n+m), s.c.=O(k), n=len(s), m=len(words), k=sum(len(words[i]))
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int wordsLen=words.length, strLen=s.length(), count=0;
        List<int[]>[] buckets=new List[26];
        for(int i=0;i<26;i++)
            buckets[i]=new ArrayList<>();
        for(int i=0;i<wordsLen;i++) 
            buckets[words[i].charAt(0)-'a'].add(new int[]{i, 0});
        for(int i=0;i<strLen;i++) {
            char ch=s.charAt(i);
            List<int[]> currBucket=buckets[ch-'a'];
            buckets[ch-'a']=new ArrayList<>();
            for(int[] pair:currBucket) {
                int wordIdx=pair[0], charIdx=pair[1]+1;
                if(charIdx==words[wordIdx].length())
                    count++;
                else 
                    buckets[words[wordIdx].charAt(charIdx)-'a'].add(new int[]{wordIdx, charIdx});
            }
        }
        return count;
    }
}
