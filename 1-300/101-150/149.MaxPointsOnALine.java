149. Max Points on a Line
Hard
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Example 1:
Input: [[1,1],[2,2],[3,3]]
Output: 3
Explanation:
^
|
|        o
|     o
|  o  
+------------->
0  1  2  3  4

Example 2:
Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
Explanation:
^
|
|  o
|     o        o
|        o
|  o        o
+------------------->
0  1  2  3  4  5  6
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

Answer:
class Solution {
    /*
        遍历每个点，看它和后面的每个点构成的直线上有多少个点
        对每个点建立map，斜率是key
        斜率要用分数的形式，不要用double的形式存
        计算分数时先求分子分母的最大公约数gcd，再都除以gcd
        重合的点特殊处理
    */
    public int maxPoints(int[][] points) {
        int result = 0;
        if(points == null) return result;
        if(points.length < 2) return points.length;
        
        for(int i = 0; i < points.length - 1; i++){
            Map<String, Integer> map = new HashMap<>();
            int overlapSelfExcluded = 0;
            int lineMaxSelfExcluded = 0;
            for(int j = i + 1; j < points.length; j++){
                int[] point1 = points[i];
                int[] point2 = points[j];
                if(point1[0] == point2[0] && point1[1] == point2[1]) {
                    overlapSelfExcluded++;
                    continue;
                }
                int numerator = point1[0] - point2[0];
                int denominator = point1[1] - point2[1];
                int gcd = generateGcd(numerator, denominator);
                String slope = (numerator / gcd) + "/" + (denominator / gcd);
                map.put(slope, map.getOrDefault(slope, 0) + 1);
                lineMaxSelfExcluded = Math.max(lineMaxSelfExcluded, map.get(slope));
            }
            result = Math.max(result, lineMaxSelfExcluded + overlapSelfExcluded + 1);
        }
        
        return result;
    }

    //记忆方法，就是靠先判断是不是一个是0了，如果是，返回不是0的那个。
    //求余数，换位置
    public int generateGcd(int x, int y){
        if(x == 0 || y == 0) return x == 0 ? y : x;
        //if(y == 0) return x; 这么写对我不友好，按上面写。
        return generateGcd(y, x % y);
    }
}
