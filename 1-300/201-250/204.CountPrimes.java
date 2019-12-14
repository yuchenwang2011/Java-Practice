204. Count Primes My Submissions QuestionEditorial Solution
Total Accepted: 57945 Total Submissions: 241727 Difficulty: Easy
Description:

Count the number of prime numbers less than a non-negative number, n.

Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.

Hint:

1. Let's start with a isPrime function. To determine if a number is prime,
we need to check if it is not divisible by any number less than n. The runtime complexity of isPrime function would be O(n) and 
hence counting the total prime numbers up to n would be O(n2). Could we do better?

More Hint:
As we know the number must not be divisible by any number > n / 2, 
we can immediately cut the total iterations half by dividing only up to n / 2. Could we still do better?
Let's write down all of 12's factors:
2 × 6 = 12
3 × 4 = 12
4 × 3 = 12
6 × 2 = 12
As you can see, calculations of 4 × 3 and 6 × 2 are not necessary. 
    Therefore, we only need to consider factors up to √n because, if n is divisible by some number p, 
then n = p × q and since p ≤ q, we could derive that p ≤ √n.
Our total runtime has now improved to O(n1.5), which is slightly better. Is there a faster approach?
The Sieve of Eratosthenes uses an extra O(n) memory and its runtime complexity is O(n log log n). 
    
Answer:
class Solution {
    public int countPrimes(int n) {
        if(n <= 2) return 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        int count = 0;
        for(int i = 2; i < isPrime.length; i++){
            if(isPrime[i]) count++;
            int j = i;
            while(j < isPrime.length){
                isPrime[j] = false;
                j += i;
            }
        }
        return count;
    }
}

//below is my O(N^2) solution, finally TLE
public class Solution {
    //遍历N能否能被从2到sqrt(N)之间的素数整除。若不能则为素数。
    //比如判断101是不是素数，只需要判断101是否能被【2，10】之间的素数整除，
    //即101是否能被2、3、5、7整除即可，如果不能，侧101就是素数。
    public int countPrimes(int n) {
        if(n == 0 || n ==1 || n == 2) return 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(2,2);
        for(int i = 2; i < n; i++){
            if(isPrime(i,map) == true) map.put(i,i);
        }
        return map.size();
    }
    public boolean isPrime(int n, HashMap<Integer,Integer> map){
        if(n == 0 || n == 1 ) return false;
        if(n == 2) return true;
        int sqrt = (int) Math.sqrt(n);
        for(int i : map.keySet()) {
            if(i <= sqrt && n % i == 0 ) return false;
        }
        return true; 
    }
}

