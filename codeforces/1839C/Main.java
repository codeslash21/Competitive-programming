// https://codeforces.com/problemset/problem/1839/C
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt(), cnt=0;
            int[] arr = new int[n];
            List<Integer> res = new ArrayList<>();
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
            if(arr[n-1]==1)
                System.out.println("NO");
            else {
                System.out.println("YES");
                for(int i=n-1;i>=0;i--) {
                    if(arr[i]==0) {
                        if(cnt!=0)
                            res.set(res.size()-1, cnt);
                        cnt=0;
                        res.add(cnt);
                    } else {
                        res.add(0);
                        cnt++;
                    }
                }
                if(cnt!=0)
                    res.set(res.size()-1, cnt);
                for(int i=0;i<n;i++)
                    System.out.print(res.get(i)+" ");
                System.out.println();
            }
        }
    }
}
