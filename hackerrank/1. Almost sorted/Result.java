import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'almostSorted' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void almostSorted(List<Integer> arr) {
    // Write your code here
        int len=arr.size();
        List<Integer> idx = new ArrayList<>();
        for(int i=1;i<len;i++)
            if(arr.get(i)<arr.get(i-1))
                idx.add(i);
        if(idx.size()==0)
            System.out.println("yes");
        else if(idx.size()==1) {
            int l=idx.get(0)-1, r=idx.get(idx.size()-1);
            if((l==0||arr.get(l-1)<arr.get(r)) && (r==len-1||arr.get(l)<arr.get(r+1)))
                System.out.println("yes\nswap "+(l+1)+" "+(r+1));
            else
                System.out.println("no");
        }
        else {
            boolean flag=true;
            for(int i=0;i<idx.size()-1;i++) {
                if(idx.get(i+1)-idx.get(i)!=1) {
                    flag=false;
                    break;
                }
            }
            int l=idx.get(0)-1, r=idx.get(idx.size()-1);
            if(!flag && idx.size()==2) {
                if((l==0||arr.get(l-1)<arr.get(r)) && (r==len-1||arr.get(l)<arr.get(r+1)))
                    System.out.println("yes\nswap "+(l+1)+" "+(r+1));
                else
                    System.out.println("no");
            }
            else if(flag) {
                if((l==0||arr.get(l-1)<arr.get(r)) && (r==len-1||arr.get(l)<arr.get(r+1)))
                    System.out.println("yes\nreverse "+(l+1)+" "+(r+1));
                else
                    System.out.println("no");
            }
            else
                System.out.println("no");
        }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.almostSorted(arr);

        bufferedReader.close();
    }
}
