class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] r=new int[n];
        int[] l=new int[n];
        
        l[0]=height[0];
        r[n-1]=height[n-1];
        for(int i=1;i<n;i++)
        {
            l[i]=Math.max(height[i],l[i-1]);
            r[n-i-1]=Math.max(height[n-i-1],r[n-i]);
        }
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum=sum+(Math.min(l[i],r[i]))-height[i];
        }
        return sum;

    }
}
