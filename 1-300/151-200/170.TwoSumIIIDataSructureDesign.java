170. Two Sum III - Data structure design My Submissions Question
Total Accepted: 10195 Total Submissions: 42385 Difficulty: Easy
Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false

Answer:
class TwoSum {
    private Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(map.containsKey(number)) map.put(number, map.get(number) + 1);
        else map.put(number, 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int a = entry.getKey();
            int b = value - a;
            if(a == b && map.get(a) > 1 || a != b && map.containsKey(b)) return true;
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
