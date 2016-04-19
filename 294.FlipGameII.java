public class Solution {
    //Got inspired by this answer
    //https://leetcode.com/discuss/64291/share-my-java-backtracking-solution
    public boolean canWin(String s) {
        if(s == null || s.length() < 2) return false;
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        return canWin(s,map);
    }
    
    public boolean canWin(String s, HashMap<String, Boolean> map){
        if(map.containsKey(s)) return map.get(s);
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == '+' && s.charAt(i+1) == '+') {
                String opponent = s.substring(0,i) + "--" + s.substring(i+2, s.length());
                if(!canWin(opponent,map)){
                    map.put(s,true);
                    return true;
                }
            }
        }
        map.put(s,false);
        return false;
    }
    
}
