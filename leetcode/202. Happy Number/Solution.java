// Using hashset
class Solution {
    private int getSum(int n) {
        int sum=0;
        while(n>0) {
            int rem=n%10;
            sum+=(rem*rem);
            n/=10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        boolean cont=true, res=true;
        while(!set.contains(n)) {
            set.add(n);
            n=getSum(n);
        }
        return n==1;
    }
}

// Using two pointers
class Solution {
    private int getSum(int n) {
        int sum=0;
        while(n>0) {
            int rem=n%10;
            sum+=(rem*rem);
            n/=10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int slow=n;
        int fast=getSum(n);
        while(fast!=1 && slow!=fast) {
            slow=getSum(slow);
            fast=getSum(getSum(fast));
        }
        return fast==1;
    }
}
