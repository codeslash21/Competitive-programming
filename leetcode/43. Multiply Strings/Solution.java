// Using normal method (elementary math)
// t.c.=O(m^2 + m.n), s.c.=O(m^2 + m.n) where m and n is the length of two numbers
class Solution {
    public StringBuilder sumResults(ArrayList<ArrayList<Integer>> results) {
        ArrayList<Integer> answer = new ArrayList<Integer>(results.get(results.size()-1));
        for(int j=0; j<results.size()-1; j++) {
            ArrayList<Integer> result = new ArrayList<Integer>(results.get(j));
            ArrayList<Integer> newAnswer = new ArrayList<>();
            int carry=0;
            for(int i=0; i<answer.size() || i<result.size(); i++) {
                int digit1=i<answer.size()? answer.get(i):0;
                int digit2=i<result.size()? result.get(i):0;
                int sum=digit1+digit2+carry;
                carry=sum/10;
                newAnswer.add(sum%10);
            }
            if(carry!=0)
                newAnswer.add(carry);
            answer=newAnswer;
        }
        StringBuilder finalAnswer = new StringBuilder();
        for(int digit:answer)
            finalAnswer.append(digit);
        
        return finalAnswer;
    }
    public ArrayList<Integer> multiplyOneDigit(StringBuilder firstNum, char secondNumDigit, int numZeros) {
        ArrayList<Integer> currentResult = new ArrayList<>();
        for(int i=0; i<numZeros; i++) 
            currentResult.add(0);
        int carry=0;
        for(int i=0; i<firstNum.length(); i++) {
            char firstNumDigit=firstNum.charAt(i);
            int multiplication = (firstNumDigit-'0')*(secondNumDigit-'0')+carry;
            carry=multiplication/10;
            currentResult.add(multiplication%10);
        }
        if(carry!=0)
            currentResult.add(carry);
        return currentResult;
    }
    
    public String multiply(String num1, String num2) {
        int len1=num1.length(), len2=num2.length();
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        StringBuilder firstNum = new StringBuilder(num1);
        StringBuilder secondNum = new StringBuilder(num2);
        firstNum.reverse();
        secondNum.reverse();
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        for(int i=0;i<len2;i++)
            results.add(multiplyOneDigit(firstNum, secondNum.charAt(i), i));
        StringBuilder answer = sumResults(results);
        answer.reverse();
        return answer.toString();
    }
}

