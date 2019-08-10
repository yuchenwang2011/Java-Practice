284. Peeking Iterator
Medium

Given an Iterator class interface with methods: next() and hasNext(), 
design and implement a PeekingIterator that support the peek() operation -- 
it essentially peek() at the element that will be returned by the next call to next().

Example:
Assume that the iterator is initialized to the beginning of the list: [1,2,3].

Call next() gets you 1, the first element in the list.
Now you call peek() and it returns 2, the next element. Calling next() after that still return 2. 
You call next() the final time and it returns 3, the last element. 
Calling hasNext() after that should return false.
Follow up: How would you extend your design to be generic and work with all types, not just integer?

Hint:
1. Think of "looking ahead". You want to cache the next element.
2. Is one variable sufficient? Why or why not?
3. Test your design with call order of peek() before next() vs next() before peek().
4. For a clean implementation, check out Google's guava library source code.

Answer:
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private Integer next;
    private Iterator<Integer> iterator;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    this.iterator = iterator;
	    if(iterator.hasNext()) {
            	next = iterator.next();
            }
	}

	public Integer peek() {
        return next;
	}

	@Override
	public Integer next() {
	    Integer result = next;
        next = iterator.hasNext() ? iterator.next() : null;  
        return result;
	}

	@Override
	public boolean hasNext() {
	    return next != null;
	}
}
