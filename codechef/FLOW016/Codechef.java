/* package codechef; // don't place package name! */
/*Using recursion*/ 
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		while(t-->0) {
		    long a,b,g,l;
    		a = input.nextInt();
    		b = input.nextInt();
    		g = gcd(a,b);
    		l = a/g*b;
    		System.out.println(g+" "+l);    
		}
		
	}
	public static long gcd(long a, long b) {
	    if(b==0) 
	        return a;
	    else 
	        return gcd(b,a%b);
	}
}

/* Using iteration*/ 
/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		while(t-->0) {
		    long a,b,g,l;
    		a = input.nextInt();
    		b = input.nextInt();
    		g = gcd(a,b);
    		l = a/g*b;
    		System.out.println(g+" "+l);    
		}
		
	}
	public static long gcd(long a, long b) {
	    while(b>0) {
	        a%=b;
	        // swap two variables
	        a = a^b^(b=a);
	    }
	    return a;
	}
}
