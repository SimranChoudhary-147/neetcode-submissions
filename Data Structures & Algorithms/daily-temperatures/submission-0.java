class Solution {
    public int[] dailyTemperatures(int[] t) {
        Stack<Integer>st=new Stack<>();
        int n=t.length;
        int [] ans=new int[n];
        
        for(int i=n-1;i>=0;i--)
        {

            while(!st.isEmpty() && t[i]>=t[st.peek()])
            {
               st.pop();
            }
            if(!st.isEmpty() && t[i]<t[st.peek()]){
                ans[i]=st.peek()-i;
               
            }   
            st.push(i);     
            
        }
        return ans;
    }
}
