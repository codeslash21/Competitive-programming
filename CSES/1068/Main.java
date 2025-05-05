// https://cses.fi/problemset/task/1068
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        while(t!=1) {
            System.out.print(t + " ");
            if (t % 2 == 0)
                t /= 2;
            else
                t = t * 3 + 1;
        }
        System.out.println(1);
    }
}
