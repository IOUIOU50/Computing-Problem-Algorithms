package Fibonacci;

import java.math.BigInteger;

/*�� Ŭ������ ������ ������ 89��° �Ǻ���ġ���� ���ϴ� ��������
 * int���� ũ���� �Ѱ�� �����÷ΰ� �Ͼ�� ���� �ذ��� Ŭ�����Դϴ�.*/
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


