 /**
 * @author Shantanoo
 *
 */
public class UglyNumber {
	
	/*
	 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
	 * 
	 * Example 1:
	 * 
	 * Input: 6
	 * Output: true
	 * Explanation: 6 = 2 × 3
	 * 
	 * Example 2:
	 * Input: 8
	 * Output: true
	 * Explanation: 8 = 2 × 2 × 2
	 * 
	 * Example 3:
	 * Input: 14
	 * Output: false
	 * Explanation: 14 is not ugly since it includes another prime factor 7.
	 * 
	 * Note:
	 * 1 is typically treated as an ugly number.
	 * 
	 **/	
	
	public static void main(String[] args) {
		UglyNumber obj = new UglyNumber();
		System.out.println("Is Ugly:" + obj.isUgly(30));
	}

	
	/**
	 * @param num
	 * @return true if it is Ugly number. Otherwise false
	 */
	public boolean isUgly(int num) {

		if (num <= 0)
			return false;

		while (num >= 0) {
			if (num == 1)
				return true;

			//Check all factors of 2, 3, 5 i.e. 30, 15, 10, 6, 5, 3, 2
			if (num % 30 == 0)
				num = num / 30;
			else if (num % 15 == 0)
				num = num / 15;
			else if (num % 10 == 0)
				num = num / 10;
			else if (num % 6 == 0)
				num = num / 6;
			else if (num % 5 == 0)
				num = num / 5;
			else if (num % 3 == 0)
				num = num / 3;
			else if (num % 2 == 0)
				num = num / 2;
			else
				return false;
		}
		return true;
	}
}
