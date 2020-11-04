
public class InsertionSort<T extends Comparable<T>> {
	private boolean less(T v, T w) {
		return v.compareTo(w) < 0;
	}
	
	public void sort(T[] a) {
		int N = a.length;
		
		for(int i=1; i<N; i++) {
			/* 기존 반복문의 조건
			 * => j>0 && array[j]<array[j-1]
			 * 여기서, array는 double형 배열이었으므로
			 * 인덱스값 j와 j-1에 해당하는 배열 요소 비교가 가능했다.
			 * 이번 과제는 제네릭과 Comparable을 이용하여
			 * 두 개의 객체를 비교하는 것이 목표이므로
			 * 삽입정렬의 조건, "앞의 요소가 더 작다?" 라는 조건을 비교하기 위해
			 * less()라는 메소드를 사용
			 * less()의 구현은 Comparable의 compareTo()메소드를 이용*/
			for(int j=i; j>0 && less(a[j], a[j-1]); j--) {
				exch(a, j, j-1);
			}
			assert isSorted(a, 0, i);
		}
		assert isSorted(a);
	}

	private boolean isSorted(T[] a) {
		return isSorted(a, 0, a.length-1);
	}

	private boolean isSorted(T[] a, int lo, int hi) {
		for(int i=lo+1; i<=hi; i++)
			if(less(a[i], a[i-1])) return false;
		return true;
	}

	private void exch(Object[] a, int left, int right) {
		Object tmp = a[left];
		a[left] = a[right];
		a[right] = tmp;
	}
	
	public void show(Object[] a) {
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
	
}
