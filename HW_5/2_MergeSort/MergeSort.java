public class MergeSort {
	/* merge sort 구현 */
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		assert isSorted(a, lo, mid);
		assert isSorted(a, mid + 1, hi);

		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}

		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[j], aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}

		assert isSorted(a, lo, hi);
	}

	private static void sort(Comparable[] a, Comparable[] aux, int begin, int end) {
		//첫 번째 개선방안 : 7번까지만 분기 -> 삽입정렬 이용
		if(end - begin < 7) {
			insertionSort(a, begin, end);
			return;
		}
		
		int mid = (begin + end) / 2;
		sort(a, aux, begin, mid);
		sort(a, aux, mid + 1, end);
		/* 두 번째 개선방안 : 만약 나뉘어저 합병하려는 두 배열에서
		 * 왼쪽 배열의 마지막 원소가 오른쪽 배열의 첫 번째 원소보다 작다면
		 * 정렬과정을 거칠 필요가 없다.*/
		if(a[mid].compareTo(a[mid+1])!=1) {
			return;
		}else
			merge(a, aux, begin, mid, end);
	}

	//알고리즘 개선 방안을 위한 삽입정렬
	private static void insertionSort(Comparable[] a, int begin, int end) {
		int N = a.length;
		
		for(int i=begin; i<=end; i++) {
			for(int j=i; j>0 && less(a[j], a[j-1]); j--) {
				exch(a, j, j-1);
			}
			assert isSorted(a, 0, i);
		}
		assert isSorted(a);
	}
	
	private static void exch(Object[] a, int left, int right) {
		Object tmp = a[left];
		a[left] = a[right];
		a[right] = tmp;
	}

	public static void sort(Comparable[] a) {
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length - 1);
		assert isSorted(a);
	}

	private static boolean less(Comparable<Comparable> v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static boolean isSorted(Comparable[] a) {
		return isSorted(a, 0, a.length - 1);
	}

	private static boolean isSorted(Comparable[] a, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	public static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
