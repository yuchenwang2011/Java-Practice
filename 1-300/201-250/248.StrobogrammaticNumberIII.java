248. Strobogrammatic Number III
Hard

A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.

Example:
Input: low = "50", high = "100"
Output: 3 
Explanation: 69, 88, and 96 are three strobogrammatic numbers.

Note:
Because the range might be a large number, the low and high numbers are represented as string.

Answer:
//same method as 247.
class Solution {
    public int strobogrammaticInRange(String low, String high) {
        int result = 0;
        if(low == null || high == null || low.length() == 0 || high.length() == 0) return result;
        
        List<String> list = new ArrayList<>();
        for(int i = low.length(); i <= high.length(); i++){
            list.addAll(helper(i, i));
        }
        for(String s : list){
            //if it's very very long string, can't use Integer.valueOf or Long.valueOf
            //since we can't compare, we can only exclude the smaller than low and bigger than high cases
            if((s.length() == low.length() && s.compareTo(low) < 0)
              || (s.length() == high.length() && s.compareTo(high) > 0)) {
                continue;
            }
            result++;
        }
        return result;
    }
    
    public List<String> helper(int idx, int n){
        if(idx == 0) return Arrays.asList("");
        if(idx == 1) return Arrays.asList(new String[]{"0","1","8"});
        List<String> last = helper(idx - 2, n);
        List<String> result = new ArrayList<>();
        for(String s : last){
            if(idx != n) result.add("0" + s + "0");
            result.add("1" + s + "1");
            result.add("6" + s + "9");
            result.add("8" + s + "8");
            result.add("9" + s + "6");
        }
        return result;
    }
}
