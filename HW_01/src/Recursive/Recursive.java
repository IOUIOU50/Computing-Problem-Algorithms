package Recursive;

public class Recursive {
	private int[] arr;
	int index;
	
	//�⺻������ 
	public Recursive() {
		this(new int[6]);
	}
	
	//������ �����ε�. recurSiveSum�� ���� ��ü�� �������ڸ��� �迭�� ���ȴ�.
	public Recursive(int[] arr) {
		this.arr = arr;
		this.index = arr.length - 1;
		
		recursiveSum(this.index);
	}
	
	/* �迭�� ���� ���ϴ� �޼ҵ�. �����Ǵ� ���ÿ� �迭�� ������ ���ǹǷ� �迭�� ������ �ε�������
	 * �迭�� �� ���̴�. */
	public int getSum() {
		return this.arr[index];
	}

	/* ����Լ�. �������� �迭�� ��ҵ��� ����Ѵ�. */
	private int recursiveSum(int index) {
		if(index == 0) {
			return this.arr[index];
		}
		else {
			//5 -> 4 -> 3 -> ... -> 0  ���� ���
			this.arr[index] += recursiveSum(--index);
			
			//�ٽ� 0 -> 1 -> 2 -> 3 -> ... -> 5
			return this.arr[++index];
		}
	}
}

