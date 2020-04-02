/**
 * @author Shantanoo
 *
 */
public class CountPrimes {

	/*
	 * Count the number of prime numbers less than a non-negative number, n.
	 * 
	 * Example:
	 * 
	 * Input: 10
	 * Output: 4
	 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
	 * 
	 **/
	public static void main(String[] args) {
		CountPrimes obj = new CountPrimes();
		System.out.println("Count: " + obj.countPrimes(13));
	}

	public int countPrimes(int n) {

		if (n <= 2)
			return 0;

    //count is started as 1 to consider the only even prime number 2
		int count = 1;
		boolean isPrime = false;
		
		//Starting from 3 and incrementing by 2 i.e. avoiding all even numbers except 2
		for (int i = 3; i < n; i = i + 2) {
			for (int j = 2; j <= Math.ceil(Math.sqrt(i)); j++) {
				if (i % j == 0 && i != j) {
					isPrime = false;
					break;
				} else
					isPrime = true;
			}

			if (isPrime) {
				count++;
			}
		}
		return count;
	}
}
