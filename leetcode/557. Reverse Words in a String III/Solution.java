// using char array
// t.c.=O(n), s.c.=O(1)
class Solution {
    private void reverse(char[] arr, int start, int end) {
        while(start<end) {
            char c = arr[start];
            arr[start++]=arr[end];
            arr[end--]=c;
        }
    }
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int start=0, end=0;
        for(int i=0;i<=n;i++) {
            if(i==n || arr[i]==' ') {
                end=i-1;
                reverse(arr, start, end);
                start=i+1;
            }
        }
        return new String(arr);
    }
}
