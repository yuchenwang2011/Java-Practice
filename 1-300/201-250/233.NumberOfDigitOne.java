233. Number of Digit One
Hard

Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

Example:
Input: 13
Output: 6 
Explanation: Digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.

Answer:
//https://blog.csdn.net/xudli/article/details/46798619\
intuitive: 
每10个数, 有一个个位是1, 
每100个数, 有10个十位是1, 
每1000个数, 有100个百位是1.  
做一个循环, 每次计算单个位上1得总个数(个位,十位, 百位).  

例子:
以算百位上1为例子:   假设百位上是0, 1, 和 >=2 三种情况: 
    case 1: n=3141092, a= 31410, b=92. 计算百位上1的个数应该为 3141 *100 次.
    case 2: n=3141192, a= 31411, b=92. 计算百位上1的个数应该为 3141 *100 + (92+1) 次. 
    case 3: n=3141592, a= 31415, b=92. 计算百位上1的个数应该为 (3141+1) *100 次. 
以上三种情况可以用 一个公式概括:

(a + 8) / 10 * m + (a % 10 == 1) * (b + 1);

class Solution {
    public int countDigitOne(int n) {
        if(n <= 0) return 0;
        int ones = 0;
        //alert!!这里必须是long
        for(long digit = 1; digit <= n; digit = digit * 10){
            //每个循环我们都在寻找当前digit的所有1，
            //比如12345， 就有1234 * 1的个位的1,因为每10个数里就有一个个位1，所以12345/10
            //比如12345，就有123 * 10个十位的1，因为每100个数里就有10/11/12/13/../19，共10个十位的1，所以12345/100
            int beforeDigit = (int) (n / digit);
            int afterDigit = (int) (n % digit);
            //这里加8的原因就是为了进位，像博客里说的，共分三种情况0,1,2，那么2的时候要进位的，那个时候多一批1
            ones += (beforeDigit + 8) / 10 * digit;
            //这个时候碰巧beforeDigit的最后一位是1，所以afterDigit那么多数，每一个都会让beforeDigit的最后一位是1,再加上100..0本身
            if(beforeDigit % 10 == 1) ones += afterDigit + 1;
        }
        return ones;
    }
}
