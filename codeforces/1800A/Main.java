// https://codeforces.com/problemset/problem/1800/A
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            String s = sc.next();
            StringBuilder sb = new StringBuilder();
            char prev = Character.toLowerCase(s.charAt(0));
            sb.append(prev);
            for(int i=1;i<n;i++) {
                char ch = Character.toLowerCase(s.charAt(i));
                if(prev!=ch) {
                    prev=ch;
                    sb.append(ch);
                }
            }
            System.out.println(sb.toString().equals("meow")?"YES":"NO");
        }
    }
}
