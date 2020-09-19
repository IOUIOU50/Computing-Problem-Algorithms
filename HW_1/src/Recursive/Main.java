package Recursive;

public class Main {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6}; //예제의 정수들로 배열 초기화
	
		//재귀함수를 가지고 있는 클래스 Recursive 인스턴스화
		Recursive recur = new Recursive(arr); 
		
		System.out.print("재귀함수 호출 후: [");
		//배열 내 모든 요소 출력
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " "); 
		}
		System.out.println("]");
		
		//배열의 총 합 = 배열의 제일 마지막 인덱스에 있는 값 출력
		System.out.print("\n"+"Sum : "+recur.getSum());
	}
}

