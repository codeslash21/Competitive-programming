// https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii/description/
// sliding window
// t.c.=O(n), s.c.=O(n)
class Solution {
    private int handleRemove(String word, Map<Character, Integer> freq, int idx, int consonantCnt) {
        char removed=word.charAt(idx);
        if(freq.containsKey(removed)) {
            freq.put(removed, freq.getOrDefault(removed, 0)-1);
            if(freq.get(removed)==0)
                freq.remove(removed);
        } else
            consonantCnt--;
        return consonantCnt;
    }
    public long countOfSubstrings(String word, int k) {
        int len=word.length(), left=0, right=0, vowelCnt=0, consonantCnt=0, nextConsonantIdx=len;
        long res=0;
        Map<Character, Integer> freq=new HashMap<>();
        Set<Character> vowels=new HashSet<>(Arrays.asList('a','e','i','o','u'));
        int[] nextConsonant=new int[len];
        for(int i=len-1;i>=0;i--) {
            nextConsonant[i]=nextConsonantIdx;
            if(!vowels.contains(word.charAt(i)))
                nextConsonantIdx=i;
        }
        while(right<len) {
            char included=word.charAt(right);
            if(vowels.contains(included))
                freq.put(included, freq.getOrDefault(included, 0)+1);
            else
                consonantCnt++;
            while(consonantCnt>k) {
                consonantCnt=handleRemove(word, freq, left++, consonantCnt);
            }
            while(freq.size()==5 && consonantCnt==k) {
                res+=nextConsonant[right]-right;
                consonantCnt=handleRemove(word, freq, left++, consonantCnt);
            }
            right++;
        }
        return res;
    }
}

// sliding window (relaxed condition)
// t.c.=O(n), s.c.=O(1)
class Solution {
    private long atLeastK(String word, int k) {
        int len=word.length(), left=0, right=0, vowelCnt=0, consonantCnt=0;
        long res=0;
        Map<Character, Integer> freq=new HashMap<>();
        Set<Character> vowels=new HashSet<>(Arrays.asList('a','e','i','o','u'));
        while(right<len) {
            char included=word.charAt(right);
            if(vowels.contains(included))
                freq.put(included, freq.getOrDefault(included, 0)+1);
            else
                consonantCnt++;
            while(freq.size()==5 && consonantCnt>=k) {
                res+=len-right;
                char removed=word.charAt(left++);
                if(freq.containsKey(removed)) {
                    freq.put(removed, freq.getOrDefault(removed, 0)-1);
                    if(freq.get(removed)==0)
                        freq.remove(removed);
                } else
                    consonantCnt--;
            }
            right++;
        }
        return res;
    }
    public long countOfSubstrings(String word, int k) {
        return atLeastK(word, k)-atLeastK(word, k+1);
    }
}
