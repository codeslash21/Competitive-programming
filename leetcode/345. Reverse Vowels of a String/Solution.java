// using two pointers
// t.c.=O(n), s.c.=O(n)
class Solution {
    public boolean isVowel(char ch) {
        String str="aeiouAEIOU";
        return str.indexOf(ch)!=-1;
    }
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int n=arr.length;
        int start=0, end=n-1;
        while(start<end) {
            if(!isVowel(arr[start]))
                start++;
            else if(!isVowel(arr[end]))
                end--;
            else{
                char temp = arr[start];
                arr[start++]=arr[end];
                arr[end--]=temp;
            }
        }
        s = new String(arr);
        return s;
    }
}
