import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main_2 {
	public static void main(String[] args) {
		QuickSelection<Integer> sort = new QuickSelection<Integer>();
		
		//1~100 정수배열 생성
		Integer[] arr = new Integer[100];
		for(int i=0; i<arr.length; i++) {
			arr[i] = i+1;
		}
		
		//정수배열을 shuffle한 배열 aux 생성
		Integer[] aux = sort.shuffle(arr);
		sort.show(aux);
		
		Integer k = 3;
		Integer boundaryIndex = arr.length-k;
		sort.select(arr, boundaryIndex);
		Integer boundaryValue = arr[boundaryIndex];
		
		Set<Integer> expected = new HashSet<Integer>();
		Collections.addAll(expected, 98, 99, 100);
		
		Set<Integer> actual = new HashSet<Integer>();
		for(int i=boundaryIndex; i<arr.length; i++) {
			Integer value = arr[i];
			if(boundaryValue <= value) {
				actual.add(value);
			}
		}
		
		//예상했던 정수 출력
		System.out.println("expected number : "+ expected);
		//실제로 찾은 정수 출력
		System.out.println("actual number : "+ actual);
		
		//assertion 결과 출력
		System.out.println(Assertions.assertEquals(expected, actual));
	}
}
