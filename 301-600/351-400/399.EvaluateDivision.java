399. Evaluate Division
Medium

Equations are given in the format A / B = k, where A and B are variables represented as strings, 
and k is a real number (floating point number). Given some queries, return the answers. 
If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0.
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, 
vector<pair<string, string>> queries , where equations.size() == values.size(), 
and the values are positive. This represents the equations. Return vector<double>.

According to the example above:
equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
 

The input is always valid. You may assume that evaluating the queries 
will result in no division by zero and there is no contradiction.

Answer:
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for(int i = 0; i < equations.size(); i++){
            List<String> number = equations.get(i);
            graph.putIfAbsent(number.get(0), new HashMap<>());
            graph.putIfAbsent(number.get(1), new HashMap<>());
            graph.get(number.get(0)).put(number.get(1), values[i]);
            graph.get(number.get(1)).put(number.get(0), 1 / values[i]);
        }
        
        double[] result = new double[queries.size()];
        for(int i = 0; i < result.length; i++){
            List<String> query = queries.get(i);
            result[i] = helper(graph, query.get(0), query.get(1), 1, new HashSet<>());
        }
        return result;
    }
    
    public double helper(Map<String , Map<String, Double>> graph, String a, String b, double val, Set<String> set){
        if(!graph.containsKey(a) || !set.add(a)) return -1; //这一行必须放前面
        if(a.equals(b)) return val;
        Map<String, Double> map = graph.get(a);
        for(String x : map.keySet()){
            double result = helper(graph, x, b, val * map.get(x), set);
            if(result != -1) return result;
        }
        return -1;
    }
}
