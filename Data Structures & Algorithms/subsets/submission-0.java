class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public void genSubsets(int i, List<Integer> suba, int[] nums) {
        if (i >= nums.length) {
            ans.add(new ArrayList<>(suba));
            return;
        }

        suba.add(nums[i]);
        genSubsets(i + 1, suba, nums);

        suba.remove(suba.size() - 1);
        genSubsets(i + 1, suba, nums);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> suba = new ArrayList<>();
        genSubsets(0, suba, nums);
        return ans;
    }
}