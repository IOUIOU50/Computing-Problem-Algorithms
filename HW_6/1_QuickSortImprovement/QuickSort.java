
public class QuickSort<T extends Comparable<T>> {
	private T[] arr;
	private static final int CUTOFF = 10;

	/* 일반적인 퀵정렬*/
	public void sort(T[] a, int lo, int hi) { 
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
        assert isSorted(a, lo, hi);
    }
	
	/* CUTOFF와 삽입정렬을 이용하여
	 * 오버헤드를 감소시킨 퀵정렬*/
	public void sortUsingInsertion(T[] a, int lo, int hi) {
		if(hi <= lo + CUTOFF - 1) {
			insertionSort(a, lo, hi);
			return;
		}
		int j = partition(a, lo, hi);
		sortUsingInsertion(a, lo, j-1);
		sortUsingInsertion(a, j+1, hi);
	}
	
	/* 중앙값을 이용하여 구현한 퀵정렬
	 * MedianOf3 방법 : 정렬하고자 하는 배열의 요소 중
	 * 처음, 중간, 마지막 3개의 원소만 가져와 정렬한 후
	 * 그 중 중간에 위치하는 값을 피벗으로 선정하는 방법*/
	public void sortUsingMedian(T[] a, int lo, int hi) {
		if(hi <= lo) return;
		
		exch(a, lo, medianOf3(a, lo, lo+(hi-lo)/2, hi));
		
		int j = partition(a, lo, hi);
		sortUsingMedian(a, lo, j-1);
		sortUsingMedian(a, j+1, hi);
	}
	
	/* 중간값을 찾는 과정*/
	private int medianOf3(T[] a, int ptrLow, int ptrMiddle, int ptrHi) {
		//중간값 : Middle
		//lo < middle < hi
		if(less(a[ptrLow], a[ptrMiddle]) && less(a[ptrMiddle], a[ptrHi])
		//hi < middle low
		|| less(a[ptrMiddle], a[ptrLow]) && less(a[ptrHi], a[ptrMiddle])) {
			System.out.println("median is middle");
			return ptrMiddle;
			}
			
		
		//중간값 : low
		//middle < low < hi
		else if(less(a[ptrLow], a[ptrHi]) && less(a[ptrMiddle], a[ptrLow])
		//hi < low < middle
		|| less(a[ptrMiddle], a[ptrLow]) && less(a[ptrLow], a[ptrMiddle])){
			System.out.println("median is Low");
			return ptrLow;
			} 
		
		//중간값 : hi
		//?? < hi < ??
		else {
			{
				System.out.println("median is Hi");
				return ptrHi;
				}
		}
	}
    
	//partition 메소드 강의자료와 동일
    private int partition(T[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        T v = a[lo];
        while (true) { 
            while (less(a[++i], v)) {
                if (i == hi) break;
            }

            while (less(v, a[--j])) {
                if (j == lo) break;      
            }

            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);

        return j;
    }

    private boolean less(T v, T w) {
        if (v == w) return false;   
        return v.compareTo(w) < 0;
    }
        
    private void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private boolean isSorted(T[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    public void show(T[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public void shuffle(T[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = (int) (Math.random() * (i + 1));
            T swap = a[r];
            a[r] = a[i];
            a[i] = swap;
        }
    }
    
	private void insertionSort(T[] a, int begin, int end) {
		
		for(int i=begin; i<=end; i++) {
			for(int j=i; j>0 && less(a[j], a[j-1]); j--) {
				exch(a, j, j-1);
			}
			assert isSorted(a, 0, i);
		}
		assert isSorted(a, begin, end);
	}

}
