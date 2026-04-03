// https://leetcode.com/problems/guess-the-word/description/
// t.c.=O(n*G), s.c.=O(n), n=number of string, G=number of times guess() is called
/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] words, Master master) {
        Random rand=new Random();
        List<String> candidates=new ArrayList<>(Arrays.asList(words));
        for(int allowedGuess=0;allowedGuess<10;allowedGuess++) {
            String guess=candidates.get(rand.nextInt(candidates.size()));
            int matches=master.guess(guess);
            if(matches==6)
                return;
            List<String> filtered=new ArrayList<>();
            candidates.stream()
                .filter(str->countMatches(guess, str)==matches)
                .forEach(filtered::add);
            candidates=filtered;
        }
    }
    private int countMatches(String target, String str) {
        int count=0;
        for(int i=0;i<6;i++)
            if(target.charAt(i)==str.charAt(i))
                count++;
        return count;
    }
}

// t.c.=O(n*G), s.c.=O(1)
class Solution {
    public void findSecretWord(String[] words, Master master) {
        List<String> candidates=new ArrayList<>(Arrays.asList(words));
        for(int allowedGuess=0;allowedGuess<30;allowedGuess++) {
            List<String> filtered=new ArrayList<String>();
            int[][] freq=new int[6][26];
            for(String word:candidates)
                for(int i=0;i<6;i++)
                    freq[i][word.charAt(i)-'a']++;
            String bestGuess=candidates.get(0);
            int bestFreqScore=0;
            for(String word:candidates) {
                int score=0;
                for(int i=0;i<6;i++)
                    score+=freq[i][word.charAt(i)-'a'];
                if(score>bestFreqScore) {
                    bestFreqScore=score;
                    bestGuess=word;
                }
            }
            int match=master.guess(bestGuess);
            if(match==6)
                return;
            for(String word:candidates)
                if(countMatches(bestGuess, word)==match)
                    filtered.add(word);
            candidates=filtered;
        }
    }
    private int countMatches(String target, String str) {
        int count=0;
        for(int i=0;i<6;i++)
            if(target.charAt(i)==str.charAt(i))
                count++;
        return count;
    }
}
