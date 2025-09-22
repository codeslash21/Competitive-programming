// https://codeforces.com/contest/1459/problem/B
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        if(t%2==0)
            System.out.println((int)Math.pow(t/2+1,2));
        else 
            System.out.println(2*(t/2+1)*(t/2+2));
    }
}
