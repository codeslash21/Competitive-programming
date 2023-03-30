// finding next max at a particular position
// t.c.=O(1), s.c.=O(1)
class Solution {
    public char findNext(char curr, char upper, char[] digits) {
        if(curr==upper)
            return digits[0];
        char max=digits[0];
        for(int i=3;i>=0;i--)
            if(digits[i]>curr && digits[i]<=upper)
                max=digits[i];
       return max;
    }
    public String nextClosestTime(String time) {
        char[] results = time.toCharArray();
        char[] digits = new char[] {results[0], results[1], results[3], results[4]};
        Arrays.sort(digits);
        results[4]=findNext(results[4], '9', digits);
        if(results[4]>time.charAt(4))
            return String.valueOf(results);
        results[3]=findNext(results[3], '5', digits);
        if(results[3]>time.charAt(3))
            return String.valueOf(results);
        results[1]=findNext(results[1], results[0]=='2'?'3':'9', digits);
        if(results[1]>time.charAt(1))
            return String.valueOf(results);
        results[0]=findNext(results[0], '2', digits);
        return String.valueOf(results);
        
    }
}
