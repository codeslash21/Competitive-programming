// https://cses.fi/problemset/task/1083
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num=sc.nextLong();
        long sum=0, total=(num*(num+1))/2;
        while(num-->1) {
            sum+=sc.nextLong();
        }
        System.out.println( total - sum);
    }
}
