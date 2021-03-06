import java.util.Random;
public class Sort {
	public static void main(String[] args) {
		Random rd = new Random();
		long startTime;
		
		/* 표본 10,000개는 삽입정렬과 셸정렬 수행시간이 너무 빨라서 측정 시간이 0ms로 나옴
		 * 따라서 표본을 100,000개로 늘림*/
		double[] array = new double[500000];
		
		for(int i=0; i<array.length; i++) {
			array[0] = rd.nextDouble();
		}
		System.out.println("표본 : 100,000개");
		/* 시간 측정 규칙
		 * 1. 정렬될 요소들은 선택, 삽입, 셸 모두 같다. => clone()이용
		 * 2. 시간 측정은 System.currentTimeMillis()을 이용
		 * 3. 메모리 누수를 막기 위해 정렬이 끝난 배열들은 null로 치환*/
		double[] selectionSortArray = array.clone();
		startTime = System.currentTimeMillis();
		selectionSort(selectionSortArray);
		System.out.println("SelectionTime : " + (System.currentTimeMillis() - startTime) + "ms");
		selectionSortArray = null;
		System.out.println();
		
		double[] insertionSortArray = array.clone();
		startTime = System.currentTimeMillis();
		insertionSort(insertionSortArray);
		System.out.println("insertionTime : " + (System.currentTimeMillis() - startTime) + "ms");
		insertionSortArray = null;
		
		double[] shellSortArray = array.clone();
		startTime = System.currentTimeMillis();
		shellSort(shellSortArray);
		System.out.println("shellTime : " + (System.currentTimeMillis() - startTime) + "ms");
		shellSortArray = null;

	}
	
	public static void selectionSort(double[] array) {
		for(int i=0; i<array.length; i++) {
			int min = i;
			for(int j=i+1; j<array.length; j++) {
				if(array[min] > array[j]) {
					min = j;
				}
			}
			double tmp = array[min];
            array[min] = array[i];
            array[i] = tmp;
		}
	}
	
	public static void insertionSort(double[] array) {
		int N = array.length;
		
		for(int i=1; i<N; i++) {
			for(int j=i; j>0 && array[j]<array[j-1]; j--) {
			     double temp = array[j];
			     array[j] = array[j-1];
			     array[j-1] = temp;
			}
		}
	}
	
	public static void shellSort(double[] array) {
		int N = array.length;
		
		int h = 1;
		while(h < N/3)
			h = 3*h + 1;

		for(int i=1; i<N; i++) {
			for(int j=i; j>=h && array[j]<array[j-1]; j-=h) {
			     double temp = array[j];
			     array[j] = array[j-h];
			     array[j-h] = temp;
			}
		}
		h = h/3;
	}
}
