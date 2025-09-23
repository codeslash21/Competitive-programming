// https://codeforces.com/problemset/problem/1883/B
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int[] chars = new int[26];
            int n = sc.nextInt(), k = sc.nextInt(), oddCnt=0;
            String s = sc.next();
            for(int i=0;i<n;i++)
                chars[s.charAt(i)-'a']++;
            for(int freq:chars)
                if(freq%2>0)
                    oddCnt++;
            System.out.println(k>=(oddCnt-1)?"YES":"NO");
        }
    }
}
