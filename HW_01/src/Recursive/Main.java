package Recursive;

public class Main {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6}; //������ ������� �迭 �ʱ�ȭ
	
		//����Լ��� ������ �ִ� Ŭ���� Recursive �ν��Ͻ�ȭ
		Recursive recur = new Recursive(arr); 
		
		System.out.print("����Լ� ȣ�� ��: [");
		//�迭 �� ��� ��� ���
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " "); 
		}
		System.out.println("]");
		
		//�迭�� �� �� = �迭�� ���� ������ �ε����� �ִ� �� ���
		System.out.print("\n"+"Sum : "+recur.getSum());
	}
}

