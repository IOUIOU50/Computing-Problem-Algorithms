package Fibonacci;

import java.math.BigInteger;

/*이 클래스는 예제의 문제가 89번째 피보나치수를 구하는 과정에서
 * int형의 크기의 한계로 오버플로가 일어나는 것을 해결한 클래스입니다.*/
public class Main_2 {
	
	public static String F(int N, String[] arr) {
		if(N == 0) {
			arr[N] = "0";
			return arr[N];
		}
		
		else if(N == 1) {
			arr[N] = "1";
			return arr[N];
		}
		
		else {
			arr[N] = calculateBigInteger(arr[N-2], arr[N-1]);
			return arr[N];
		}
	}
	
	public static String calculateBigInteger(String arg1, String arg2) {
		String result = "";
		
		BigInteger big1 = new BigInteger(arg1);
		BigInteger big2 = new BigInteger(arg2);
		
		result = big1.add(big2).toString();
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = new String[90];
		
		for(int N=0; N<90; N++) {
			System.out.println(N + " " + F(N, arr));
		}
	}

}


