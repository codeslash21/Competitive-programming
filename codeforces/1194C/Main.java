// https://codeforces.com/problemset/problem/1194/C
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        l: while(T-->0) {
            String s=sc.next(), t=sc.next(), p=sc.next();
            int sLen=s.length(), tLen=t.length(), pLen=p.length(), i=0, j=0;
            int[] freq = new int[26];
            for(char c:p.toCharArray())
                freq[c-'a']++;
            while(j<tLen) {
                if(i<sLen && s.charAt(i)!=t.charAt(j)) {
                    char tChar=t.charAt(j);
                    if(freq[tChar-'a']>0) {
                        freq[tChar-'a']--;
                        j++;
                    } else {
                        System.out.println("NO");
                        continue l;
                    }
                } else if(i>=sLen) {
                    char tChar=t.charAt(j);
                    if(freq[tChar-'a']>0) {
                        freq[tChar-'a']--;
                        j++;
                    } else {
                        System.out.println("NO");
                        continue l;
                    }
                }
                else {
                    i++;
                    j++;
                }
            }
            System.out.println(i==sLen && j==tLen?"YES":"NO");
        }
    }
}
