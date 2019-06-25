277. Find the Celebrity My Submissions Question
Total Accepted: 5261 Total Submissions: 15035 Difficulty: Medium
Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, 
there may exist one celebrity. The definition of a celebrity is 
that all the other n - 1 people know him/her but he/she does not know any of them.
Now you want to find out who the celebrity is or verify that there is not one. 
The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?"
to get information of whether A knows B. 
You need to find out the celebrity (or verify there is not one) 
by asking as few questions as possible (in the asymptotic sense).
You are given a helper function bool knows(a, b) which tells you whether A knows B. 
Implement a function int findCelebrity(n), 
your function should minimize the number of calls to knows.
Note: There will be exactly one celebrity if he/she is in the party. 
Return the celebrity's label if there is a celebrity in the party. 
If there is no celebrity, return -1.

Answer: 
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        //Inspired by this solution
        //https://leetcode.com/discuss/56413/java-solution-two-pass
        int candidate = -1;
        if( n <= 0) return candidate;
        candidate = 0;  //assume the first person is the celebrity 
        for(int i = 1; i <= n-1; i++){
            if(knows(candidate,i)) candidate =i; //if cele knows i, it means it's fake
            //and also people knows i, so i can be a candidate
            //if i don't know any people after i, it means, i is known by last fake cele, and don't know people behind him
            //that means i is a possible candidate
        }
        
        //next round is to double check if the candidate is real
        for(int i = 0; i <= n-1; i++){
            //note, in the if statement, must use return, you can't set candidate = -1. because loop not finished yet
            //candidate can't know others and everyone must know candidate
            if(i < candidate && (knows(candidate,i) == true || knows(i,candidate) == false)) return -1;
            if(i > candidate && !knows(i,candidate)) return -1; //knows(cele,i) is checked in last round,when i>cele
        }
        
        return candidate;
    }
}
