import junit.framework.Assert;

public class HappyNumber {

	/*
	 * Happy Number
	 * 
	 * A happy number is a number defined by the following process: Starting with
	 * any positive integer, replace the number by the sum of the squares of its
	 * digits, and repeat the process until the number equals 1 (where it will
	 * stay), or it loops endlessly in a cycle which does not include 1. Those
	 * numbers for which this process ends in 1 are happy numbers.
	 * 
	 * Example:
	 * 
	 * Input: 19 
	 * Output: true 
	 * Explanation: 
	 * 1^2 + 9^2 = 82 
	 * 8^2 + 2^2 = 68 
	 * 6^2 + 8^2 = 100 
	 * 1^2 + 0^2 + 0^2 = 1
	 * 
	 * Input: 44 
	 * Output: true 
	 * Explanation: 
	 * 4^2 + 4^2 = 32 
	 * 3^2 + 2^2 = 13 
	 * 1^2 + 3^2 = 10 
	 * 1^2 + 0^2 = 1
	 * 
	 * Input: 4 
	 * Output: false 
	 * Explanation: 
	 * 4^2 = 16 
	 * 1^2 + 6^2 = 37 
	 * 3^2 + 7^2 = 58
	 * 5^2 + 8^2 = 89 
	 * 8^2 + 9^2 = 145 
	 * 1^2 + 4^2 + 5^2 = 42 
	 * 4^2 + 2^2 = 20 
	 * 2^2 + 0^2 = 4
	 * 
	 * Input: 11 
	 * Output: false 
	 * Explanation:
	 * 1^2 + 1^2 = 2
	 * 2^2 = 4
	 * 4^2 = 16 
	 * 1^2 + 6^2 = 37 
	 * 3^2 + 7^2 = 58
	 * 5^2 + 8^2 = 89 
	 * 8^2 + 9^2 = 145 
	 * 1^2 + 4^2 + 5^2 = 42 
	 * 4^2 + 2^2 = 20 
	 * 2^2 + 0^2 = 4
	 */
	public static void main(String[] args) {

		HappyNumber obj = new HappyNumber();
		Assert.assertEquals(true, obj.checkHappyNumber(19));
		Assert.assertEquals(true, obj.checkHappyNumber(44));
		Assert.assertEquals(false, obj.checkHappyNumber(4));
		Assert.assertEquals(false, obj.checkHappyNumber(11));
	}

	/**
	 * @param n
	 * @return true if Happy Number, otherwise false
	 */
	public boolean checkHappyNumber(int n) {

		if (n == 1 || n == 7) // Since there are only two numbers (1 & 7) below 10 which does not ends in a cycle
			return true;
		else if (n < 10)
			return false;

		int fast = n;

		do {
			// Using 2 pointer variables to detect loop i.e. Floyd Cycle Detection
			n = digitSquareSum(n);
			fast = digitSquareSum(digitSquareSum(fast));

			if (fast == 1 || fast == 7)
				return true;

		} while (n != fast);
		return false;
	}

	private int digitSquareSum(int numToCheck) {
		int sum = 0;
		while (numToCheck > 0) {
			sum = (int) (sum + Math.pow((numToCheck % 10), 2));
			numToCheck = numToCheck / 10;
		}
		return sum;
	}
}
