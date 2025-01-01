//https://codeforces.com/contest/2043/problem/B
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            StringBuilder sb = new StringBuilder();
            int n = sc.nextInt();
            int d = sc.nextInt();
            sb.append("1 ");
            if(d%3==0 || n>2)
                sb.append("3 ");
            if(d==5)
                sb.append("5 ");
            if(d==7 || n>2)
                sb.append("7 ");
            if(d==9 || (n>2 && d%3==0) || n>5)
                sb.append("9");
            System.out.println(sb.toString());
        }
    }
}
