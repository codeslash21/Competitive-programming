// https://codeforces.com/problemset/problem/1374/B
import java.util.*;

public class B_Multiply_by_2_divide_by_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n=sc.nextInt(), cntTwo=0, cntThree=0, num=n, target=1;
            while(num%3==0) {
                num/=3;
                cntThree++;
                target*=3;
            }
            num=n;
            while(num%2==0) {
                num/=2;
                cntTwo++;
                target*=2;
            }
            System.out.println(target!=n?-1:(cntTwo>cntThree?-1:2*cntThree-cntTwo));
        }
    }
}
