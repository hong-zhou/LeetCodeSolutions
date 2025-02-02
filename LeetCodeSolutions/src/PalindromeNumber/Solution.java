package PalindromeNumber;
/*
Determine whether an integer is a palindrome. Do this without extra space.

Thoughts

Problems related with numbers are frequently solved by / and %. 
No need of extra space is required. This problem is similar with the Reverse Integer problem. 
Note: no extra space here means do not convert the integer to string, since string will be a copy of the integer and take extra space. 
The space take by div, left, and right can be ignored.


Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.
*/

public class Solution {
	public boolean isPalindrome(int x) {
        // negative numbers are not palindrome
		if (x < 0) return false;
		
		// initialize how many zero
		int div = 1;
		while (x / div >= 10){
			div *= 10;
		}
		
		while (x != 0){
			int left = x / div;
			int right = x % 10;
			
			if (left != right) return false;
			
			x = (x % div) / 10;
			div /= 100;
		}
		
		return true;
    }
}
