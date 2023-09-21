// using array
// t.c.=O(n), s.c.=O(n)
class Solution {
    public String reverseOnlyLetters(String s) {
        char[] str = s.toCharArray();
        int left=0, right=str.length-1;
        while(left<right) {
            if(Character.isAlphabetic(str[left]) && Character.isAlphabetic(str[right])) {
                char temp=str[left];
                str[left++]=str[right];
                str[right--]=temp;
            }
            while(left<right && !Character.isAlphabetic(str[left]))
                left++;
            while(left<right && !Character.isAlphabetic(str[right]))
                right--;
        }
        return new String(str);
    }
}
