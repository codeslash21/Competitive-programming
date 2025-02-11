//https://codeforces.com/contest/2059/problem/C
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt(), count = 0;
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<n;i++) {
                count = 0;
                for(int j=0;j<n;j++) {
                    int num = sc.nextInt();
                    if(num == 1)
                        count++;
                    else
                        count = 0;
                }
                list.add(count);
            }
            Collections.sort(list);
            int mex = 0;
            for(int i=0;i<n;i++) {
                if(list.get(i)>=mex)
                    mex++;
            }
            System.out.println(mex);
        }
     }
}
