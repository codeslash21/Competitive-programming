// https://codeforces.com/problemset/problem/1869/A
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n=sc.nextInt(), cnt=0;
            int[] arr = new int[n+1];
            for(int i=1;i<=n;i++) {
                arr[i]=sc.nextInt();
                if(arr[i]==0)
                    cnt++;
            }
            if(n%2==0) 
                System.out.println(2+"\n"+"1 "+n+"\n"+"1 "+n);
            else 
                System.out.println(4+"\n"+"1 "+(n-1)+"\n"+"1 "+(n-1)+"\n"+(n-1)+" "+n+"\n"+(n-1)+" "+n);   
        }
    }
}
