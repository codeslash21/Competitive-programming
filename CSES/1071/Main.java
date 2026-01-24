// https://cses.fi/problemset/task/1071
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0) {
            int y=sc.nextInt(), x=sc.nextInt();
            long res=0;
            if(y<=x)
                if(x%2>0)
                    res=x*x + 1 - y;
                else
                    res=x*x-2*x+y+1;
            else
                if(y%2>0)
                    res=y*y-2*y+x+1;
                else
                    res=y*y+1-x;
            System.out.println(res);
        }
    }
}
