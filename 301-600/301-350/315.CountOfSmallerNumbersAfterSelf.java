315. Count of Smaller Numbers After Self
Hard

You are given an integer array nums and you have to return a new counts array. 
The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:
Input: [5,2,6,1]
Output: [2,1,1,0] 

Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.

Accepted 96,739 Submissions 242,037

Answer:
class Solution {
    class Node{
        int val;
        int idx;
        public Node(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        
        Node[] nodes = new Node[nums.length];
        for(int i = 0; i < nums.length; i++){
            nodes[i] = new Node(nums[i], i);
        }
        Integer[] smallers = new Integer[nums.length];
        Arrays.fill(smallers, 0);
        mergeSort(nodes, smallers);
        result.addAll(Arrays.asList(smallers));
        return result;
    }
    
    public Node[] mergeSort(Node[] nodes, Integer[] smallers){
        if(nodes.length <= 1) return nodes;
        int mid = nodes.length / 2;
        Node[] left = mergeSort(Arrays.copyOfRange(nodes, 0, mid), smallers);
        Node[] right = mergeSort(Arrays.copyOfRange(nodes, mid, nodes.length), smallers);
        int i = 0; 
        int j = 0;
        while(i < left.length || j < right.length){
            //这里j必须在前面，不然后面right[j]会溢出
            if(j == right.length || (i < left.length && left[i].val <= right[j].val)) {
                nodes[i + j] = left[i];
                //对于左边的这个元素来说，居然有j个元素跑到我的左边也就是比我小了，那么我就该加j啊
                //idx是从来不变的，所以就对应着这个数字，还是按顺序的，smaller的顺序从来不变
                smallers[left[i].idx] += j;
                i++;
            } else {
                nodes[i + j] = right[j];
                j++;
            }
        }
        return nodes;
    }
}
