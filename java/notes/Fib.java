public class Fib {
	public static void main(String[] args) {
		int start = 5;
		System.out.println( fibNumber(start) );
	}


	public static int fibNumber(int n) {
		System.out.println( "fibNumber: " + n);
		int result = 0;
		if(n==1 || n==2 ) {
			result = 1;
		} else {
			result = fibNumber(n-1) + fibNumber(n-2);
		}

		return result;
	}
}