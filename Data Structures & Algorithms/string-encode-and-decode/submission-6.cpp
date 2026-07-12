class Solution {
public:
    string encode(vector<string>& strs) {
        string encoded = "";
        for (string s : strs) {
            encoded += to_string(s.length()) + "#" + s;
        }
        return encoded;
    }

    vector<string> decode(string s) {
        vector<string> decoded;
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (s[j] != '#') j++;  // Find the separator
            int len = stoi(s.substr(i, j - i));  // Get length
            string str = s.substr(j + 1, len);   // Extract string
            decoded.push_back(str);
            i = j + 1 + len;  // Move to next encoded string
        }
        return decoded;
    }
};
