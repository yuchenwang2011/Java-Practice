247. Strobogrammatic Number II My Submissions QuestionEditorial Solution
Total Accepted: 7716 Total Submissions: 22698 Difficulty: Medium
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

For example,
Given n = 2, return ["11","69","88","96"].

Hint:

Try to use recursion and notice that it should recurse with n - 2 instead of n - 1.

Answer:
class Solution {
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }
    
    public List<String> helper(int idx, int n){
        if(idx == 0) return Arrays.asList("");
        if(idx == 1) {
            return Arrays.asList(new String[]{"0", "1", "8"});
        }
        List<String> last = helper(idx - 2, n);
        List<String> result = new ArrayList<>();
        for(String s : last){
            //意思这不是最外围那层，因为test case不让两边是零
            if(idx != n) result.add("0" + s + "0");
            result.add("1" + s + "1");
            result.add("6" + s + "9");
            result.add("8" + s + "8");
            result.add("9" + s + "6");
        }
        return result;
    }
}
