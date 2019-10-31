128. Longest Consecutive Sequence
Hard

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.
Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Answer:
//必须掌握两种解法
class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        if(nums == null || nums.length == 0) return result;
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }
        for(int n : nums){
            int lower = n - 1;
            int upper = n + 1;
            while(set.contains(lower)){
                set.remove(lower);
                lower--;
            }
            while(set.contains(upper)){
                set.remove(upper);
                upper++;
            }
            result = Math.max(result, upper - lower - 1);
        }
        return result;
    }
}


class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        UnionFind uf = new UnionFind(nums.length);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])) continue;
            map.put(nums[i], i);
            
            if(map.containsKey(nums[i] + 1)) {
                uf.union(i, map.get(nums[i] + 1));
            }
            if(map.containsKey(nums[i] - 1)) {
                uf.union(i, map.get(nums[i] - 1));
            }
        }
        return uf.maxCount();
    }
    
    public class UnionFind{
        int[] parent;
        //这里的union find是用数组的index来建立的，union和find的都是index
        public UnionFind(int n){
            parent = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }
        
        public int find(int id){
            if(id == parent[id]) return id;
            parent[id] = find(parent[id]);
            return parent[id];
        }
        
        public void union(int id1, int id2){
            int root1 = find(id1);
            int root2 = find(id2);
            if(root1 != root2) {
                parent[root1] = root2;
            }
        }
        
        public int maxCount(){
            int max = 0;
            int[] count = new int[parent.length];
            for(int i = 0; i < parent.length; i++){
                //这里就是找出带头大哥的出现次数
                //每个小弟都挨个问一遍，你大哥是谁，然后把大哥票数加1,最后看哪个大哥票数最多
                count[find(i)]++;
                max = Math.max(max, count[find(i)]);
            }
            return max;
        }
    }
}
