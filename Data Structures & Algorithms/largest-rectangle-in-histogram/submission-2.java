class Solution {
    public int largestRectangleArea(int[] h) {
        int n=h.length;
            int[] left = new int[n];
            int[] right = new int[n];

            Arrays.fill(left, -1);
            Arrays.fill(right, n);

            // Next Smaller Element on Right
            Stack<Integer> st = new Stack<>();
            for (int i = 0; i < n; i++) {
                while (!st.isEmpty() && h[i] < h[st.peek()]) {
                    right[st.pop()] = i;
                }
                st.push(i);
            }

            // Next Smaller Element on Left
            st.clear();
            for (int i = n - 1; i >= 0; i--) {
                while (!st.isEmpty() && h[i] < h[st.peek()]) {
                    left[st.pop()] = i;
                }
                st.push(i);
            }

            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, h[i] * (right[i] - left[i] - 1));
            }

            return ans;
        }
}
