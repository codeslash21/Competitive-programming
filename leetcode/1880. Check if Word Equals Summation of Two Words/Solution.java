// t.c.=O(n), s.c.=O(n), where n is the number of characters in string
class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<firstWord.length();i++)
            sb.append(firstWord.charAt(i)-'a');
        long firstValue = Integer.valueOf(sb.toString());
        sb.delete(0, sb.length());
        for(int i=0;i<secondWord.length();i++)
            sb.append(secondWord.charAt(i)-'a');
        long secondValue = Integer.valueOf(sb.toString());
        sb.delete(0, sb.length());
        for(int i=0;i<targetWord.length();i++)
            sb.append(targetWord.charAt(i)-'a');
        long targetValue = Integer.valueOf(sb.toString());
        return targetValue==(firstValue+secondValue);
    }
}
