class Solution {

    public String minWindow(String s, String t) {

        if (s.length() < t.length())
            return "";

        int[] fs = new int[128];
        int[] ft = new int[128];

        for (char c : t.toCharArray())
            ft[c]++;

        int left = 0;
        int formed = 0;

        int start = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            fs[c]++;

            if (ft[c] > 0 && fs[c] <= ft[c])
                formed++;

            while (formed == t.length()) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char remove = s.charAt(left);

                fs[remove]--;

                if (ft[remove] > 0 && fs[remove] < ft[remove])
                    formed--;

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}