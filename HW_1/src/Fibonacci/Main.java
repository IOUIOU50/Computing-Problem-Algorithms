package Fibonacci;

/* 기존의 코드는 N>40이 되는 지점에서 급격히 속도가 저하된다.
 * N값이 1씩 증가할 때마다 F(N-1)과 F(N-2)를 재귀호출하기 때문인데
 * 이는 지수함수의 꼴로 수행시간이 증가하게 된다.
 * 이를 해결하기 위해 배열을 선언하여 F(N)값을 저장해 재사용하면  
 * F(N-1)과 F(N-2)가 이미 배열의 요소로 있기 때문에 
 * N>=2인 경우에 F(N-2)와 F(N-1)을 계산할 필요가 없다.*/
public class Main {

	public static long F(int N, int[] arr) {
		if(N == 0) {
			arr[N] = 0;
			return arr[N];
		}
		
		else if(N == 1) {
			arr[N] = 1;
			return arr[N];
		}
		
		else {
			arr[N] = arr[N-1] + arr[N-2];
			return arr[N];
		}
			
	}

	public static void main(String[] args) {
		//F(N)의 결과를 재사용하기 위한 정수형 배열 선언
		int[] arr = new int[90];
		
		for(int N = 0; N<90; N++) {
			System.out.println(N + " " + F(N, arr));
		}
	}
}

