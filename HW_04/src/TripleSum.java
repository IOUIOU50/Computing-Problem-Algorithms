import java.util.Arrays;

public class TripleSum {
	/* 3-SUM을 brute-force로 찾으면 n^3의 시간복잡도를 가짐*/
	public static void main(String[] args) {
		int[] a = {30, -40, -20, -10, 40, 0, 10, 5};
		int cnt = 0;
		
		/* 단계 1 : 배열 정렬하기
		 * java.util.Arrays가 제공하는 sort()메소드 이용
		 * 이 sort()메소드는 평균적 시간복잡도가 nlogn이지만 
		 * 빅오표기법으로 나타낸 시간복잡도는 O(n^2)이다.*/
		Arrays.sort(a);
		
		/* 단계 2 : 배열 '쌍'을 만들어 a[i] + a[j]를 구한다.
		 * 그 뒤 이 '쌍'과 합이 0이되는 배열의 다른 요소를 찾아 cnt를 증가 */
		for(int i=0; i<a.length; i++) {
			for(int j=i+1; j<a.length; j++) {
				int twoSum = a[i] + a[j];
				int index = binarySearch(a, -twoSum);
				
				/* 배열의 '다른' 요소를 찾아야한다.
				 * 예를들어, 이미 -20, 10이 선택된 상태에서
				 * 10이 한번 더 선택되어선 안된다.
				 * 따라서 이미 선택된 요소의 색인값 i, j는 예외시켜야 한다.*/
				if((index != -1) && (index != i)&& (index != j))
					cnt++;
					
			}
		}
		
		/* 현재 cnt값은 중복을 고려하지 않음
		 * ex) 
		 * (-40, 0, 40)
		 * (-40, 40, 0)
		 * (0, 40, -40)
		 * 각 경우의 수마다 총 3번의 중복이 발생*/
		System.out.println("경우의 수 : "+cnt/3);
	}
	
	public static int binarySearch(int[] a, int key) {
		int lo = 0, hi = a.length-1;
		while(lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if(key < a[mid])
				hi = mid - 1;
			else if(key > a[mid])
				lo = mid + 1;
			else
				return mid;
		}
		return -1; //no searching data
	}
}
