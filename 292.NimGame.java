292. Nim Game   My Submissions QuestionEditorial Solution
Total Accepted: 65157 Total Submissions: 123554 Difficulty: Easy
You are playing the following Nim Game with your friend: 
There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. 
The one who removes the last stone will be the winner. 
You will take the first turn to remove the stones.

Both of you are very clever and have optimal strategies for the game. 
Write a function to determine whether you can win the game given the number of stones in the heap.

For example, if there are 4 stones in the heap, 
then you will never win the game: no matter 1, 2, or 3 stones you remove, 
the last stone will always be removed by your friend.

Hint:

If there are 5 stones in the heap, 
could you figure out a way to remove the stones such that you will always be the winner?

Answer:
public class Solution {
    //俩小孩拿石头，第一个小孩可以拿走四的余数，剩下的时候不管对方拿多少，就拿可以凑成4的数，这样每次凑四
    //这样就可以保证自己拿走最后的一把。所以对于是个4的倍数来说，第一个小孩不管怎么拿，第二个小孩只要拿走相应的凑四的话
    //这样第二个小孩可以保证自己肯定赢
    public boolean canWinNim(int n ){
        if(n <= 0 ) return false;
        return n % 4 !=0;
    }
    /*
    public boolean canWinNim(int n) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        System.out.println(Integer.MAX_VALUE);
        return helper(n, map);
    }
    
    public boolean helper(int n, HashMap<Integer, Boolean> map){
         if(n<=3) return true;
         if(map.containsKey(n)) return map.get(n);
         for(int i = 1; i <=3; i++){
             if(!helper(n-i, map)) {
                 map.put(n-i,true);
                 return true;
             }
         }
         map.put(n, false);
         return false;
    }
    */
}
