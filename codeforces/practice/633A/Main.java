//https://codeforces.com/contest/633/problem/A
import java.util.Scanner;

public class Main
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        boolean flag = false;
        for(int i=0;i<=c;i++)
            if(i%a==0 && (c-i)%b==0) {
                flag = true;
                break;
            }
        if(!flag)
            System.out.println("NO");
        else
            System.out.println("YES");
    }
}
