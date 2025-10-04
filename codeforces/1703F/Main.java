// https://codeforces.com/problemset/problem/1703/F
import java.util.*;

public class Main {
    public static int binarySearch(List<Integer> arr, int ele) {
        int left=0, right=arr.size()-1;
        while(left<=right) {
            int mid = left + (right-left)/2;
            if(arr.get(mid)<ele) 
                left=mid+1;
            else 
                right=mid-1;
        }
        return left;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n=sc.nextInt();
            long res=0;
            List<Integer> arr = new ArrayList<>();
            for(int i=1;i<=n;i++) {
                int ele=sc.nextInt();
                if(ele>=i)
                    continue;
                int idx=binarySearch(arr, ele);
                if(idx>=0)
                    res+=idx;
                arr.add(i);
            }
            System.out.println(res);
        }
    }
}
