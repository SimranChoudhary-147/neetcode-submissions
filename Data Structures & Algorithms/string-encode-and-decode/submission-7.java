class Solution {

    public String encode(List<String> strs) {
        String res="";
        for(String str: strs)
        {
            int len=str.length();
            res+=(len+"#");
            res+=str;
        }
        return res;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int n=str.length();
        int i=0;
        while(i<n){
            String temp="";
            while(str.charAt(i) != '#')
            {
                temp += str.charAt(i);
                i++;
            }
            int intTemp=Integer.parseInt(temp);
            String trans = str.substring(i + 1, i + 1 + intTemp);
            result.add(trans);
            i += intTemp + 1;
        }
        return result;

    }
}
