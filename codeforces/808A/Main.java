// https://codeforces.com/problemset/problem/808/A
import java.util.*;

public class A_Lucky_Year {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt(), pow=0, num=n;
        while(num>9) {
            num /= 10;
            pow++;
        }
        num+=1;
        num=num*(long)Math.pow(10, pow);
        System.out.println(num-n);
    }
}
