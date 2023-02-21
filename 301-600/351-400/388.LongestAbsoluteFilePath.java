388. Longest Absolute File Path
Medium

Suppose we abstract our file system by a string in the following manner:
The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
dir
    subdir1
    subdir2
        file.ext
The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:
dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext 
and an empty second-level sub-directory subsubdir1. 
subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.

We are interested in finding the longest (number of characters) absolute path to a file within our file system. 
For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", 
and its length is 32 (not including the double quotes).
Given a string representing the file system in the above format, 
return the length of the longest absolute path to file in the abstracted file system. 
If there is no file in the system, return 0.

Note:
The name of a file contains at least a . and an extension.
The name of a directory or sub-directory will not contain a ..
Time complexity required: O(n) where n is the size of the input string.

Notice that a/aa/aaa/file1.txt is not the longest file path, 
if there is another path aaaaaaaaaaaaaaaaaaaaa/sth.png.

Accepted 72,667 Submissions 181,282

Answer:
// \t or \n is escaped characters in String to represent tab or new line. So length of \t only counts as 1.
class Solution {
    public int lengthLongestPath(String input) {
        int result = 0;
        if(input == null || input.length() == 0) return result;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0); //a dummy root folder
        String[] strings = input.split("\n");
        for(String s : strings){
            int numT = s.lastIndexOf("\t") + 1;
            int level = numT + 1;
            
            while(level < stack.size()) stack.pop();
            int len = stack.peek() + s.length() - numT + 1; //add a / at end
            stack.push(len);
            if(s.contains(".")) result = Math.max(result, len - 1); //remove the end /
        }
        return result;
    }
}

//这是带注释版
public class Solution {
    public int lengthLongestPath(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        String[] arr = input.split("\n");
        int maxLen = 0;
        stack.push(0); //dummy null length
        for (String s: arr) {
            /*
            numOfTabs is the number of "\t", numOfTabs = 0 
            when "\t" is not found, because s.lastIndexOf("\t") returns -1.
            So normally, the first parent "dir" have numOfTabs 0.
            */
            int numOfTabs = s.lastIndexOf("\t") + 1; //searching for \t counts the escape, so \t\t\t, last one returns 2, not 3, adding one makes it 3
            /* Level is defined as numOfTabs + 1. 
            For example, in "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext", 
            dir is level 1, subdir1 and subdir2 are level 2, file.ext is level3
            */
            int level = numOfTabs + 1;
            /*
            The following part of code is the case that we want to consider when there are
            several subdirectories in a same level. We want to remove
            the path length of the directory or the file of same level
            that we added during previous step, and calculate 
            the path length of current directory or file that we are currently looking at.
            */
            while (level < stack.size()) stack.poll(); 
            int curLen = stack.peek() + (s.length() - numOfTabs) + 1;
            stack.push(curLen);
            if (s.contains(".")) maxLen = Math.max(maxLen, curLen - 1); //Only update the maxLen when a file is discovered, 
            // And remove the "/" at the end of file
        }
        return maxLen;
    }
}
