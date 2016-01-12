import java.utils.*;
public class Solution {
    //You can finish the quesiton by both char[] array or HashMap
    //Of course this question asks you to use HashMap as Unicode needs 10,000 elements
    //And always remember, when answer, the first thing to do is to check null or length 0
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null) { //Let's assume here we don't accept null
            return false;
        }
        if(s.length==0 || t.length ==0 || s.length != t.length){// Let's assume here we don't accept length 0
            return false;
        }
        
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        HashMap<Character, Integer> myHash = new HashMap<Character,Integer>();
        //First round to count the frequency and save into HashMap
        for(int i = 0; i < arr1.length; i++) {
            if(myHash.get(arr1[i])!=null){//it means this letter has appeared before
                myHash.put(arr1[i],myHash.get(arr1[i])+1);
            } else {
                myHash.put(arr1[i],1); //it means this is the first time the letter appears
            }
        }
        //Second round to compare if the frequency the same and if it doen't even have this letter
        for(int i=0; i< arr2.length; i++) {
            if(myHash.get(arr2[i]) == null || myHash.get(arr2[i]) == 0){ //it means this letter never appears before
                return false;
            } else {
                myHash.push(arry2[i],myHash.get(arry2[i])-1);
            }
            
        }
        return true;
    }
}
