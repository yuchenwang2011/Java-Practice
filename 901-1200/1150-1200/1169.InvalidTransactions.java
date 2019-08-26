1169. Invalid Transactions
Easy


A transaction is possibly invalid if:
the amount exceeds $1000, or;
if it occurs within (and including) 60 minutes of another transaction with the same name in a different city.
Each transaction string transactions[i] consists of comma separated values 
representing the name, time (in minutes), amount, and city of the transaction.

Given a list of transactions, return a list of transactions that are possibly invalid.  
You may return the answer in any order.

Example 1:
Input: transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
Output: ["alice,20,800,mtv","alice,50,100,beijing"]
Explanation: The first transaction is invalid because the second transaction occurs 
within a difference of 60 minutes, have the same name and is in a different city. 
Similarly the second one is invalid too.

Example 2:
Input: transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
Output: ["alice,50,1200,mtv"]

Example 3:
Input: transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
Output: ["bob,50,1200,mtv"]
 
Constraints:
1. transactions.length <= 1000
2. Each transactions[i] takes the form "{name},{time},{amount},{city}"
3. Each {name} and {city} consist of lowercase English letters, and have lengths between 1 and 10.
4. Each {time} consist of digits, and represent an integer between 0 and 1000.
5. Each {amount} consist of digits, and represent an integer between 0 and 2000.
Accepted 1,744 Submissions 8,489

Hint:
1. Split each string into four arrays.
2. For each transaction check if it's invalid, 
you can do this with just a loop with help of the four arrays generated on step 1.
3. At the end you perform O(N ^ 2) operations.

Answer:
class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> result = new ArrayList<>();
        if(transactions == null || transactions.length == 0) return result;
        int len = transactions.length;
        String[] names = new String[len];
        int[] times = new int[len];
        int[] money = new int[len];
        String[] cities = new String[len];
        boolean[] adds = new boolean[len];
        for(int i = 0; i < transactions.length; i++){
            String[] tran = transactions[i].split(",");
            names[i] = tran[0];
            times[i] = Integer.valueOf(tran[1]);
            money[i] = Integer.valueOf(tran[2]);
            cities[i] = tran[3];
        }
        
        for(int i = 0; i < len; i++){
            if(money[i] >= 1000) adds[i] = true;
            for(int j = i + 1; j < len; j++){
                //这里三个条件
                if(names[i].equals(names[j]) && Math.abs(times[i] - times[j]) <= 60 && !cities[i].equals(cities[j])) {
                    //这里要改俩
                    adds[i] = true;
                    adds[j] = true;
                }
            }
        }
        
        for(int i = 0; i < len; i++){
            if(adds[i]) result.add(transactions[i]);
        }
        return result;
    }
}
