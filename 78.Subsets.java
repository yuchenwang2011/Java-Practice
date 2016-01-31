78. Subsets My Submissions Question
Total Accepted: 81715 Total Submissions: 270372 Difficulty: Medium
Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

Answer:
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //I'm inspired by this Chinese answer
        //https://leetcode.com/discuss/25696/simple-java-solution-with-for-each-loops
        //There are still some answers I don't understand, will do them next round
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        if(nums == null || nums.length == 0){
            return result;
        }
        Arrays.sort(nums);
        for(int i =0; i < nums.length; i++){
            int size = result.size();
            for(int j =0; j < size; j++){
                //Here it must be a new object, otherwise you just moved the tmp pointer to 
                //the object, and chaned the original object in the result
                List<Integer> tmp = new ArrayList<Integer>(result.get(j));
                tmp.add(nums[i]);
                result.add(tmp);
            }
        }
        return result;
    }
}

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      //The second solution is inspired by these two solutions
      //https://leetcode.com/discuss/9213/my-solution-using-bit-manipulation
      //http://www.jiuzhang.com/solutions/subsets/
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      if(nums == null || nums.length ==0){
          result.add(new ArrayList<Integer>());
          return result;
      }
      Arrays.sort(nums);
      int n = nums.length;
      for(int i = 0; i < (1<<n); i++){
          List<Integer> tmp = new ArrayList<Integer>();
          for(int j = 0; j < n; j++){
              //here just to find the ith bit whether equal to 1
              //because this case it happens to be,say 101 represents {1,3} for [1,2,3]
              //here it can't be 1 because the result is 0100 something like that
              if( (i&(1<<j)) != 0){ 
                 tmp.add(nums[j]);
              }
          }
          result.add(tmp);
      }
      return result;
    }
}

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      //Inspired by this answer
      //http://blog.csdn.net/u011095253/article/details/9158397
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      if(nums.length == 0 || nums == null){
          return result;
      }
      List<Integer> tmp = new ArrayList<Integer>();
      result.add(tmp);
      Arrays.sort(nums);
      dfs(0,nums,result,tmp);
      return result;
    }
    
    public void dfs(int idx, int[] nums, List<List<Integer>> result, List<Integer> tmp){
        for(int i = idx; i < nums.length; i++){
            tmp.add(nums[i]);
            result.add(new ArrayList<Integer>(tmp));
            dfs(i+1,nums,result,tmp);
            tmp.remove(tmp.size()-1);//remove the last one
        }
    }
    
}

这道题是要求生成所有子集，那么首先我们有一个能返回所有子集的ArrayList res, 
和一个临时变量ArrayList tmp, 当tmp满足一定条件的时候，往res里面添加结果
Subset这道题的条件比较直观，就是每当我们添加了一个元素，都是一个新的子集。
那么我们怎么保证不会出现重复集合呢。我们引入一个int pos用来记录此子集的起点在哪，
比如当pos = 1的时候就是从第二个元素往后循环添加元素（0 base）,
每次当此层用了第i个元素，那么下一层需要传入下一个元素的位置i+1 除此之外，
当循环结束要返回上一层dfs的时候我们需要把这一层刚添加元素删去。

比如输入集合为［1，2，3］应当是这么运行，
[]
[1]
[1,2]
[1,2,3] //最底层子循环到头返回删去3，上一层的子循环也到头删去2
          //而此时，这一层循环刚到2，删去后还可以添加一个3
[1,3] //删除3，删除1
[2]
[2,3] //删除3，删除2
[3]
