//Following the rules
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int myAtoi(String s) {
        int sign = 1, result=0, index=0, len=s.length();
        while(index<len && s.charAt(index)==' ')
            index++;
        if(index<len && (s.charAt(index)=='+' || s.charAt(index)=='-')) {
            sign = s.charAt(index)=='-'?-1:1;
            index++;
        }
        while(index<len && Character.isDigit(s.charAt(index))) {
            int digit=s.charAt(index)-'0';
            if(result>(Integer.MAX_VALUE-digit)/10)
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            result = result*10 + digit;
            index++;
        }
        return sign*result;
    }
}

// Using finite state machine
// t.c.=O(n), s.c.=O(1)
enum State {q0, q1, q2, qd};
class StateMachine {
    private State currentState;
    private int result, sign;
    public StateMachine() {
        currentState = State.q0;
        result=0;
        sign = 1;
    }
    private void toStateQ1(char ch) {
        sign = ch=='-'?-1:1;
        currentState = State.q1;
    }
    private void toStateQ2(int digit) {
        currentState = State.q2;
        appendDigit(digit);
    }
    private void toStateQd() {
        currentState = State.qd;
    }
    private void appendDigit(int digit) {
        if(result>(Integer.MAX_VALUE-digit)/10) {
            if(sign==1)
                result=Integer.MAX_VALUE;
            else {
                result = Integer.MIN_VALUE;
                sign=1;
            }
            toStateQd();
        }
        else
            result = result*10+digit;
    }
    public void transition(char ch) {
        if(currentState==State.q0) {
            if(ch==' ')
                return;
            else if(ch=='-' || ch=='+') 
                toStateQ1(ch);
            else if(Character.isDigit(ch)) 
                toStateQ2(ch-'0');
            else
                toStateQd();
        }
        else if(currentState==State.q1 || currentState==State.q2) {
            if(Character.isDigit(ch))
                toStateQ2(ch-'0');
            else
                toStateQd();
        }
    }
    public int getInteger() {
        return sign*result;
    }
    public State getState() {
        return currentState;
    }
}

class Solution {
    public int myAtoi(String s) {
        StateMachine Q = new StateMachine();
        for(int i=0;i<s.length() && Q.getState()!=State.qd;i++)
            Q.transition(s.charAt(i));
        return Q.getInteger();
    }
}
