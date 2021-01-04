
public class QuickSelection<T extends Comparable<T>> {
	public T select(T[] a, int k) {
		int lo = 0, hi = a.length-1;
		
		while(hi > lo) {
			int j = partition(a, lo, hi);
			if(j < k) lo = j + 1;
			else if(j < k) hi = j - 1;
			else return a[k];
		}
		return a[k];
	}

    public T[] shuffle(T[] a) {
        T[] arr = a;
        int n = arr.length;
        
        for (int i = 0; i < n; i++) {
            int r = (int) (Math.random() * (i + 1));
            T swap = arr[r];
            arr[r] = arr[i];
            arr[i] = swap;
        }
        
        return arr;
    }    
    
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
    
    public void show(T[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
            if(i%10==9)
            	System.out.println();
        }
        System.out.println();
    }

}
