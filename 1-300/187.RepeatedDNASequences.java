187. Repeated DNA Sequences My Submissions QuestionEditorial Solution
Total Accepted: 40485 Total Submissions: 163117 Difficulty: Medium
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". 
When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].

Answer:
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s == null || s.length() < 10) return new ArrayList<String>();
        HashSet<String> once = new HashSet<String>();
        HashSet<String> repeat = new HashSet<String>();
        for(int i = 0 ; i + 10 <= s.length(); i++) {
            String check = s.substring(i,i+10);
            if(once.add(check) == false) repeat.add(check);
        }
        return new ArrayList<String>(repeat);
    }
}
