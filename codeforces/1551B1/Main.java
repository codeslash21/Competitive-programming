// https://codeforces.com/contest/1551/problem/B1
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            String s=sc.next();
            int[] freq = new int[26];
            int len=s.length(), cnt=0;
            for(int i=0;i<len;i++) 
                freq[s.charAt(i)-'a']++;
            for(int i=0;i<26;i++)
                cnt+=freq[i]>2?2:freq[i];
            System.out.println(cnt/2);
        }
    }
}
