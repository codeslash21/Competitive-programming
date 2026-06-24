// https://leetcode.com/problems/verifying-an-alien-dictionary/description/
// using sorting
// t.c.=O(m*nlogn), s.c.=O(m*n)
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderIndex=new int[26];
        int len=words.length, alphabets=order.length();
        for(int i=0;i<alphabets;i++)
            orderIndex[order.charAt(i)-'a']=i;
        Comparator<String> compare=(w1, w2)-> {
            for(int i=0;i<Math.min(w1.length(), w2.length());i++) {
                if(w1.charAt(i)!=w2.charAt(i))
                    return orderIndex[w1.charAt(i)-'a']-orderIndex[w2.charAt(i)-'a'];
            }
            return w1.length()-w2.length();
        };
        String[] sortedWords=words.clone();
        Arrays.sort(sortedWords, compare);
        return Arrays.equals(words, sortedWords);
    }
}

// by checking lexicographical order
// t.c.=O(m*n), s.c.=O(1)
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderIndex=new int[26];
        int len=words.length, alphabets=order.length();
        for(int i=0;i<alphabets;i++)
            orderIndex[order.charAt(i)-'a']=i;
        for(int i=0;i<len-1;i++) {
            String w1=words[i], w2=words[i+1];
            for(int j=0;j<w1.length();j++) {
                // if w2 is shorter than w1 return false
                if(j==w2.length())  return false;
                if(w1.charAt(j)!=w2.charAt(j)) {
                    if(orderIndex[w1.charAt(j)-'a']>orderIndex[w2.charAt(j)-'a'])
                        return false;
                    break;
                }
            }
        }
        return true;
    }
}
