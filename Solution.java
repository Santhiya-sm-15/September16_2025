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