class Solution {
    public int maxProfit(int[] prices) {
        
        int n=prices.length;
        int[] ans=new int[n];
        ans[0]=prices[0];
        for(int i=1;i<n;i++ )
        {
            ans[i]=Math.min(ans[i-1],prices[i]);
        }
        ans[n-1]=Math.abs(prices[n-1]-ans[n-1]);
        int mp=ans[n-1];
        for(int i=n-2;i>=0;i--)
        {
            // val=Math.max(prices[i+1],prices[i]);
            ans[i]=Math.abs(ans[i]-prices[i]);
            mp=Math.max(mp,ans[i]);
        }
        return mp;
    }
}
