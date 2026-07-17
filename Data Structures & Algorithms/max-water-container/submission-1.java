class Solution {
    public int maxArea(int[] heights) {
        int start=0;
        int n=heights.length;
        int end=n-1;
        int area=0;
        while(start<end){
            area = Math.max(area,(end - start) * Math.min(heights[start], heights[end]) );
        if(heights[start]<heights[end]) start++;
            else end--;
        }
        return area;
    }
}
