1) Fibonacci series
Write a java program to print fibonacci  series  without using  recursion and using recursion.
Input: 10
Output: 0 1 1 2 3 5 8 13 21 34


//Recursion
public class Solution{
	public List<Integer> fibonacci(int n){
		List<Integer> result = new ArrayList<Integer>();
		if(n <= 0) {
			result.add(0);
			return result;
		}
		if(n == 1) {
			result.add(0);
			result.add(n);
			return result;
		}
		result.add(0);
		result.add(1);
		fibonacciHelper(n, 2, result);
		return result;
	}

	public void fibonacciHelper(int n, int i, List<Integer> result){
		if(i >= n || i < 2) return;
		
		result.add(result.get(i-1) + result.get(i-2));
		fibonacciHelper(n, i + 1, result);
	}
}


//Iterative
public class Solution{
	public void fibonacci(int n){
		int first = 0;
		int second = 1;
		int third = first + second;
		if(n <= 0) {
			System.out.print(first);
			return;
		}
		System.out.print(first + " " + second);
		if(n == 1) {
			return;
		}
		int i = 2;
		while(i < n){
			third = first + second;
			System.out.print(" " + third);
			first = second;
			second = third;
			i++;
		}
	}
}



2) Prime number
Write a java program to check prime number.
Input: 44
Output: not prime number
Input: 7
Output: prime number

public class Solution{
	public String isPrime(int n){
		String result = "prime number";
		if(n <= 1) return "not " + result; 
		if(n == 2) return result;
		for(int i = 2; i <= (int) Math.sqrt(n); i++) {
			if(n % i == 0) return "not " + result;
		}
		return result;
	}
}



3) Palindrome number
Write a java program to check palindrome number.
Input: 329
Output: not palindrome number
Input: 12321
Output: palindrome number


public class Solution{
	public String isPalindrome(int n){
		String result = "palindrome number";
		if(n < 0) return "not " + result;
		if(n == 0) return result;
		int backup  = n;
		int sum = 0;
		while(n != 0){
			int tmp = n % 10;
			sum = sum * 10 + tmp;
			n = n / 10;
		}
		return sum == backup ? result : "not " + result;
	}
}



4) Factorial number
Write a java program to print factorial of a number.
Input: 5
Output: 120
Input: 6
Output: 720

public class Solution{
	public int Factorial(int n){
		if(n < 0) return 0;
		if(n == 0) return 1;
		return Factorial(n - 1) * n;
	}
}


6) Bubble Sort
Write  a  java  program  to  sort  an  array  elements  using  bubble  sort
algorithm.
Input: 18 9 33 4 84 32
Output: 4 9 18 32 33 84

	public void bubbleSort(int[] nums){
		for(int i = 0; i < nums.length; i++){
			for(int j = 0; j < nums.length - i - 1; j++){
				if(nums[j] > nums[j+1]) {
					int tmp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = tmp;
				}
			}
		}
	}


7) Selection Sort
Write  a  java  program  to  sort  an  array  elements  using  selection  sort
algorithm.
Input: 18 9 33 4 84 32
Output: 4 9 18 32 33 84

public class Solution{
	public void sort(int[] nums){
		for(int i = 0; i < nums.length; i++){
			int max = 0;
			for(int j = 0; j < nums.length - i; j++){
				if(nums[j] > nums[max]) max = j;
			}
			swap(nums.length - 1 - i, max, nums);
		}
	}

	public void swap(int i, int j, int[] nums){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}


8) Insertion Sort
Write  a  java  program  to  sort  an  array  elements  using  insertion  sort
algorithm.
Input: 18 9 33 4 84 32
Output: 4 9 18 32 33 84
Java Searching Programs


public class Solution{
	public void sort(int[] nums){
		for(int i = 0; i < nums.length - 1; i++){
			for(int j = i + 1; j > 0; j--){
				if(nums[j] < nums[j - 1]){
					swap(j, j - 1, nums);
				}
			}
		}

	}
	public void swap(int i, int j, int[] nums){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}


16) Remove Duplicate Element in an Array
Write a java program to remove duplicate element in an array.
Input: 10,20,20,30,30,40,50,50
Output: 10 20 30 40 50

public class Solution{
	public void removeDuplicate(int[] nums){
		Arrays.sort(nums);
		int dedup = 1;
		for(int i = 1; i < nums.length; i++){
			if(nums[i] != nums[i - 1]){
				nums[dedup++] = nums[i];
				continue;
			}
		}
		for(int i = 0; i< dedup; i++) {
			System.out.print(nums[i]);
		}
	}
}



20) Transpose matrix
Write a java program to transpose a matrix.
Output:
Printing Matrix without transpose:
1 3 4
2 4 3
3 4 5
Printing Matrix After Transpose:
1 2 3
3 4 4
4 3 5 

public class Solution{
	public int[][] transpostMatrix(int[][] matrix){
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return matrix;
		int row = matrix.length;
		int colum = matrix[0].length;
		int i = 0, j = 0;
		while(i <= row && j <= colum){
			if( (i == 0 && j == 0) || (i == row && j == colum)) {
				i++;
				j++;
				continue;
			}
			for(int k = 0; k <= i && k <= j; k++) {
				int tmp = matrix[i - k][j];
				matrix[i-k][j] = matrix[i][j-k];
				matrix[i][j-k] = tmp;	
			}
			i++;
			j++;
		}
		return matrix;
	}
}