// https://cses.fi/problemset/task/1619/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(), arrIdx=0, deptIdx=0, res=0, personCnt=0;
        int[] arr=new int[n], dept=new int[n];
        for(int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
            dept[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        Arrays.sort(dept);
        while(arrIdx<n && deptIdx<n) {
            if(arr[arrIdx]<=dept[deptIdx]) {
                personCnt++;
                arrIdx++;
            } else {
                personCnt--;
                deptIdx++;
            }
            res=Math.max(res, personCnt);
        }
        System.out.println(res);
    }
}
