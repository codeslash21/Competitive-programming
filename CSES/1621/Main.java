// https://cses.fi/problemset/task/1621/

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), count=0;
        for(int i=0;i<n;i++) {
            int x=sc.nextInt();
            set.add(x);
        }
        System.out.println(set.size());
    }
}
