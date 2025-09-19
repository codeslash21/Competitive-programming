// https://codeforces.com/contest/1328/problem/A
import java.util.*;

public class A_Divisibility_Problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int a = sc.nextInt(), b = sc.nextInt();
            System.out.println(a%b==0?0:b-a%b);
        }
    }
}
