71. Simplify Path My Submissions Question
Total Accepted: 48712 Total Submissions: 224714 Difficulty: Medium
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".

Answer:
public class Solution {
    public String simplifyPath(String path) {
        while(path.indexOf("//") >= 0){
            path = path.trim().replaceAll("//","/");
        }
        if(path == null || path.length() == 0) return "/";
        if(path.charAt(0) != '/') path = "/" + path;
        String[] strings = path.split("/");
        Deque<String> stack = new ArrayDeque<String>();
        for(int i = 1; i < strings.length; i++){
            if(strings[i].equals(".")) continue;
            else if(strings[i].equals("..")) {
                if(!stack.isEmpty()) stack.pop();
            }
            else stack.push("/" + strings[i]);
        }
        String result = "";
        for(String str : stack){
            result = str + result;
        }
        return result.length() == 0 ? "/" : result;
    }
}
//Test case: "/a/./c/../b/", "/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///"

//updated May12 2019
class Solution {
    public String simplifyPath(String path) {
        String result = "";
        if(path == null || path.length() == 0) return "/" + result;
        
        String[] paths = path.split("/+");
        Deque<String> stack = new ArrayDeque<>();
        
        for(String s : paths){
            if(s.equals("..")) {
                if(!stack.isEmpty()) stack.pop();
            } else if(s.equals(".") || s.length() == 0){
                continue;
            } else {
                stack.push(s);
            }
        }
        while(!stack.isEmpty()){
            result = "/" + stack.pop() + result;
        }
        return result.length() == 0? "/" : result;
    }
}
