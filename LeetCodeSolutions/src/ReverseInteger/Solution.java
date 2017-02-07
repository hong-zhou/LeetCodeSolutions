package ReverseInteger;
/*********************************************
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
**************************************/

public class Solution {
	public int reverse(int x) {
		long result = 0;
		while (x != 0){
			result = result * 10 + x % 10;
			if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
				return 0;
			}           
			x = x / 10;
		}       
		return (int)result;
	}
}

// alternate solution using java8
/*public class Solution {
    public int reverse(int x) {
        int r = 0;
        while (x!=0) {
            try{
                r = Math.multiplyExact(r,10);
                r = Math.addExact(r, x%10);
            }
            catch (ArithmeticException e){
                return 0;
            }
            x = x/10;
        }
        return r;
    }
}*/
