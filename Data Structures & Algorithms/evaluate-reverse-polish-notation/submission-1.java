class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {

            if (Character.isDigit(tokens[i].charAt(0)) ||
                (tokens[i].length() > 1 && tokens[i].charAt(0) == '-')) {

                st.push(Integer.parseInt(tokens[i]));
            } else {

                int opr2 = st.pop();
                int opr1 = st.pop();

                if (tokens[i].equals("+"))
                    st.push(opr1 + opr2);
                else if (tokens[i].equals("-"))
                    st.push(opr1 - opr2);
                else if (tokens[i].equals("*"))
                    st.push(opr1 * opr2);
                else if (tokens[i].equals("/"))
                    st.push(opr1 / opr2);
            }
        }

        return st.pop();
    }
}