class Solution {
    public boolean checkInclusion(String s1, String s2) {
       if (s1.length() > s2.length()) return false;

        int[] fs1 = new int[26];
        int[] fs2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            fs1[s1.charAt(i) - 'a']++;
            fs2[s2.charAt(i) - 'a']++;
        }
        if (matches(fs1, fs2)) return true;
        int left=0;

       for(int right=s1.length();right < s2.length(); right++){
            fs2[s2.charAt(right) - 'a']++;
            fs2[s2.charAt(left) - 'a']--;
            left++;

            if (matches(fs1, fs2)) return true;
        }

        return false;

       
    }
     private boolean matches(int[] count1, int[] count2) {
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) return false;
        }
      
         return true;
    }
}
