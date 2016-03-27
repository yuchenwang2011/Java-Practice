299. Bulls and Cows My Submissions Question
Total Accepted: 23430 Total Submissions: 80440 Difficulty: Easy
You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.

For example:

Secret number:  "1807"
Friend's guess: "7810"
Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B".

Please note that both secret number and friend's guess may contain duplicate digits, for example:

Secret number:  "1123"
Friend's guess: "0111"
In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.

Credits:
Special thanks to @jeantimex for adding this problem and creating all test cases.

Answer:
public class Solution {
    //********Remember how to use array as a HashTable!!!!
    //This question was so hard for me to understand, but if you try to write 1234 and 4321/abcd on paper, you will get it
    //This OJ has some probem, it doesn't consider the case "1234" "123"
    //https://leetcode.com/discuss/67031/one-pass-java-solution
    public String getHint(String secret, String guess) {
        if(secret == null || secret.length() == 0 || guess == null || guess.length() == 0) return "0A0B";
        if(secret.length() < guess.length()) return "";//OJ doesn't have this case
        int[] map = new int[10]; //to save the frequency for number 0,1...9
        int bull = 0, cow = 0;
        for(int i = 0; i < secret.length(); i ++){
            if(secret.charAt(i) == guess.charAt(i)) {
                bull++;
            }
            else {
                //when secret finds it's element's frequency got changed, means guess 捷足先登了
                if(map[secret.charAt(i) - '0'] < 0) cow++;
                //when guess finds it's element is bigger than 0, 只有当guess里有这个字母的时候才能去查这个字母的频率啊
                if(map[guess.charAt(i) - '0'] > 0) cow++;
                map[secret.charAt(i) - '0']++;
                map[guess.charAt(i) - '0'] --;
            }
        }
        return bull + "A" + cow + "B";
    }
}
