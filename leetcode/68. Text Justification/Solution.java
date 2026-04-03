// https://leetcode.com/problems/text-justification/description/
// greedy approach
// t.c.=O(n*maxWidth), s.c.=O(1)
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> sentences=new ArrayList<String>();
        int wordsCount=words.length, idx=0;
        while(idx<wordsCount) {
            int lineStart=idx, lineWidth=words[idx].length();
            idx++;
            while(idx<wordsCount && lineWidth+1+words[idx].length()<=maxWidth)
                lineWidth+=(1+words[idx++].length());
            int totalWords=idx-lineStart, numGap=totalWords-1;
            int totalChars=lineWidth-numGap, totalSpace=maxWidth-totalChars;
            StringBuilder sentence=new StringBuilder();
            // Last line or single word: left-justified
            if(idx==wordsCount || totalWords==1) {
                for(int i=lineStart;i<idx;i++) {
                    if(i>lineStart)
                        sentence.append(' ');
                    sentence.append(words[i]);
                }
                // pad remaining width with extra spaces
                int totalPadding=totalSpace-numGap;
                while(totalPadding-->0)
                    sentence.append(' ');
            } else {
                int evenSpacePerGap=totalSpace/numGap, extraSpace=totalSpace%numGap;
                for(int i=lineStart;i<idx;i++) {
                    if(i>lineStart) {
                        // left gaps get one extra space if remainder exists
                        int spaceToAdd=evenSpacePerGap+(i-lineStart<=extraSpace?1:0);
                        while(spaceToAdd-->0)
                            sentence.append(' ');
                    }
                    sentence.append(words[i]);
                }
            }
            sentences.add(sentence.toString());
        }
        return sentences;
    }
}
