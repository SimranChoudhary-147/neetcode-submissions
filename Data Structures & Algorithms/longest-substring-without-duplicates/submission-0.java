class Solution {

    public int lengthOfLongestSubstring(String s) {

        Set<Character> st = new HashSet<>();

        int i = 0;
        int j = 0;
        int maxL = 0;

        while (j < s.length()) {

            if (!st.contains(s.charAt(j))) {

                st.add(s.charAt(j));

                maxL = Math.max(maxL, j - i + 1);

                j++;
            }
            else {

                st.remove(s.charAt(i));
                i++;
            }
        }

        return maxL;
    }
}