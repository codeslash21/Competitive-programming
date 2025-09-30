// https://codeforces.com/problemset/problem/1277/B
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n=sc.nextInt(), res=0;
            TreeSet<Integer> arr = new TreeSet<>();
            for(int i=0;i<n;i++)
                arr.add(sc.nextInt());
            while(!arr.isEmpty()) {
                int ele = arr.last();
                arr.remove(ele);
                if(ele%2==0) {
                    arr.add(ele/2);
                    res++;
                }
            }
            System.out.println(res);
        }
    }
}
