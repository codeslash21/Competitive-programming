// https://codeforces.com/problemset/problem/1606/A
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            String s = sc.next();
            int len = s.length();
            System.out.println(s.charAt(0)==s.charAt(len-1)?s:s.charAt(len-1)+s.substring(1));
        }
    }
}
