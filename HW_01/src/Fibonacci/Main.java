package Fibonacci;

/* ������ �ڵ�� N>40�� �Ǵ� �������� �ް��� �ӵ��� ���ϵȴ�.
 * N���� 1�� ������ ������ F(N-1)�� F(N-2)�� ���ȣ���ϱ� �����ε�
 * �̴� �����Լ��� �÷� ����ð��� �����ϰ� �ȴ�.
 * �̸� �ذ��ϱ� ���� �迭�� �����Ͽ� F(N)���� ������ �����ϸ�  
 * F(N-1)�� F(N-2)�� �̹� �迭�� ��ҷ� �ֱ� ������ 
 * N>=2�� ��쿡 F(N-2)�� F(N-1)�� ����� �ʿ䰡 ����.*/
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
		//F(N)�� ����� �����ϱ� ���� ������ �迭 ����
		int[] arr = new int[90];
		
		for(int N = 0; N<90; N++) {
			System.out.println(N + " " + F(N, arr));
		}
	}
}

