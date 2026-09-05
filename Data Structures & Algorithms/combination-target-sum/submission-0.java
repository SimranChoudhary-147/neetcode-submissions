class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public void genSubsets(int i, List<Integer> suba, int[] nums, int target, int s) {

       
        if (s == target) {
            ans.add(new ArrayList<>(suba));
            return;
        }

        
        if (i >= nums.length || s > target) {
            return;
        }

        // Include nums[i]
        suba.add(nums[i]);
        genSubsets(i, suba, nums, target, s + nums[i]);

        // Backtrack
        suba.remove(suba.size() - 1);

        // Exclude nums[i]
        genSubsets(i + 1, suba, nums, target, s);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        genSubsets(0, new ArrayList<>(), nums, target, 0);
        return ans;
    }
}