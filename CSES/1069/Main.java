// https://cses.fi/problemset/task/1069
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dna=sc.next();
        int left=0, right=0, len=dna.length(), maxLen=0;
        while(right<len) {
            if(dna.charAt(right)==dna.charAt(left))
                right++;
            else {
                maxLen=Math.max(maxLen, right-left);
                left=right;
            }
        }
        maxLen=Math.max(maxLen, right-left);
        System.out.println(maxLen);
    }
}
