271. Encode and Decode Strings My Submissions Question
Total Accepted: 5987 Total Submissions: 22247 Difficulty: Medium
Design an algorithm to encode a list of strings to a string. 
  The encoded string is then sent over the network and is decoded back to the original list of strings.

Machine 1 (sender) has the function:

string encode(vector<string> strs) {
  // ... your code
  return encoded_string;
}
Machine 2 (receiver) has the function:
vector<string> decode(string s) {
  //... your code
  return strs;
}
So Machine 1 does:

string encoded_string = encode(strs);
and Machine 2 does:

vector<string> strs2 = decode(encoded_string);
strs2 in Machine 2 should be the same as strs in Machine 1.

Implement the encode and decode methods.

Note:
The string may contain any possible characters out of 256 valid ascii characters. 
  Your algorithm should be generalized enough to work on any possible characters.
Do not use class member/global/static variables to store states. 
  Your encode and decode algorithms should be stateless.
Do not rely on any library method such as eval or serialize methods. 
  You should implement your own encode/decode algorithm.

Answer:
//这题必会，substring的练习题
public class Codec {
    public String encode(List<String> strs) {
        String result = "";
        if(strs == null || strs.size() == 0) return result;
        for(String s : strs){
            result += s.length() + "/" + s;
        }
        return result;
    }

    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
        int i = 0;
        while(i < s.length()){
            //这题练习的就是substring的用法
            int slash = s.indexOf("/", i);
            int length = Integer.valueOf(s.substring(i, slash));
            String str = s.substring(slash + 1, slash + 1 + length);
            result.add(str);
            i = slash + 1 + length;
        }
        return result;
    }
}
