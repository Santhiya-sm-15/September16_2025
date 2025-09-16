# September16_2025
The problem that i solved today

You are given an array of strings arr[] that represents a valid arithmetic expression written in Reverse Polish Notation (Postfix Notation). Your task is to evaluate the expression and return an integer representing its value.

Note: A postfix expression is of the form operand1 operand2 operator (e.g., "a b +"). 
And the division operation between two integers always computes the floor value.
It is guaranteed that the result of the expression and all intermediate calculations will fit in a 32-bit signed integer.

Code:
class Solution {
    public int evaluatePostfix(String[] arr) {
        Stack<Integer> st=new Stack<>();
        for(String x:arr)
        {
            if(x.equals("+"))
            {
                int n1=st.pop();
                int n2=st.pop();
                st.push(n1+n2);
            }
            else if(x.equals("-"))
            {
                int n2=st.pop();
                int n1=st.pop();
                st.push(n1-n2);
            }
            else if(x.equals("*"))
            {
                int n1=st.pop();
                int n2=st.pop();
                st.push(n1*n2);
            }
            else if(x.equals("/"))
            {
                int n2=st.pop();
                int n1=st.pop();
                st.push(Math.floorDiv(n1,n2));
            }
            else if(x.equals("^"))
            {
                int n2=st.pop();
                int n1=st.pop();
                st.push((int)Math.pow(n1,n2));
            }
            else
                st.push(Integer.parseInt(x));
        }
        return st.pop();
    }
}
