class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> arrs=new ArrayList<>();
        int n=nums.length;
      
        for(int i=0;i<n-2;i++)
        {
            if(i>0 && nums[i]==nums[i-1])
            {
             continue;
            }
        
        int k=n-1;
        int j=i+1;
        while(j<k)
        { 
           int sum=nums[i]+nums[j]+nums[k];
            if(sum==0)
            {
                arrs.add(Arrays.asList(nums[i], nums[j], nums[k]));

                j++;
                k--;
            
            while(j<k && nums[j]==nums[j-1])
                j++;
            while(j<k && nums[k]==nums[k+1])
                k--;
            }
            else if(sum<0)
            {
                j++;
            }
            else{
                k--;
            }
        }
    }
    return arrs;
    }
    
}
