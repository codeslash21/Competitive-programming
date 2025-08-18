// https://codeforces.com/problemset/problem/1800/A
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            String s = sc.next().toLowerCase();
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(0));
            for(int i=1;i<n;i++) {
                char ch = s.charAt(i);
                if(ch!=s.charAt(i-1)) 
                    sb.append(ch);
            }
            System.out.println(sb.toString().equals("meow")?"YES":"NO");
        }
    }
}
