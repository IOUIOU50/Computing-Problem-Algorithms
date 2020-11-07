package Recursive;

public class Recursive {
	private int[] arr;
	int index;
	
	//기본생성자 
	public Recursive() {
		this(new int[6]);
	}
	
	//생성자 오버로딩. recurSiveSum을 통해 객체가 생성되자마자 배열이 계산된다.
	public Recursive(int[] arr) {
		this.arr = arr;
		this.index = arr.length - 1;
		
		recursiveSum(this.index);
	}
	
	/* 배열의 합을 구하는 메소드. 생성되는 동시에 배열의 내용이 계산되므로 배열의 마지막 인덱스값이
	 * 배열의 총 합이다. */
	public int getSum() {
		return this.arr[index];
	}

	/* 재귀함수. 증감시켜 배열의 요소들을 계산한다. */
	private int recursiveSum(int index) {
		if(index == 0) {
			return this.arr[index];
		}
		else {
			//5 -> 4 -> 3 -> ... -> 0  까지 재귀
			this.arr[index] += recursiveSum(--index);
			
			//다시 0 -> 1 -> 2 -> 3 -> ... -> 5
			return this.arr[++index];
		}
	}
}

