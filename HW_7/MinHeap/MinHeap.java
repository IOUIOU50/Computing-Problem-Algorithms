import java.util.ArrayList;
import java.util.Arrays;

public class MinHeap<T extends Comparable<T>> {
	private T[] array;
	private int maxSize;
	private int size;
	private int tail;
	
	public MinHeap() {
		this.array = (T[]) new Comparable[1]; 
		this.maxSize = array.length;
		this.tail = 0;
		this.size = 0;
	}
	
	public void insert(T e) {
		size++;
		if(tail == maxSize-1) resize(maxSize*2); //resize정책 구현
		
		/* 배열의 0번 인덱스는 사용하지 않기 때문에
		 * tail이 1증가한 상태에서 삽입이 수행된다.
		 * 따라서, 최초 생성시에 배열의 크기는 2(0, 1번 인덱스)이고 tail은 0인상태에서
		 * tail을 1증가시킨 뒤 1번 인덱스부터 저장 시작*/
		tail++; //배열의 0번 인덱스는 사용X
		array[tail] = e; //따라서, tail이 1증가한 상태에서 삽입
		swim(tail);
	}
	
	//resize 알고리즘
	private void resize(int max) {
		T[] newArray = (T[])new Comparable[max];
		for(int i=0; i<=tail; i++) {
			newArray[i] = array[i];
		}
		array = newArray;
		maxSize = array.length;
		System.out.println("Stack capacity has been changed. "
				+ "Current capacity"+ " is " + this.maxSize);
	}

	private void swim(int pos) {
		while(1<pos) {
			T child = array[pos];
			T parent = array[pos/2];

			/* <변경점>
			 * more(parentD, child)
			 * -> less(parent, child)
			 * <설명>
			 * MinHeap이기 때문에 부모보다 자식이 더 작아야함 */
			if(less(parent, child)) break;
			else {
				exch(pos, pos/2);
				pos /= 2;
			}
			
			/* 강의자료에서 제시된 코드의 의문점
			 * MinHeap의 경우 정렬 상태가(우선순위가)
			 * right child> left child > parent(우선순위는 역순) 순으로 유지되어야 하는데
			 * insert() -> swim()과정에서 right child > left child를 유지하는
			 * 알고리즘이 존재하지 않음.
			 * 따라서 해당 부분 알고리즘을 구현하였음. */
			if(maxSize%2!=0 && less(array[pos+1], array[pos])){
				exch(pos+1, pos);
			}
			
		}
	}
	
    private void exch(int i, int j) {
        T swap = array[i];
        array[i] = array[j];
        array[j] = swap;
    }

	private boolean less(T v, T w) {
        if (v == w) return false;   
        return v.compareTo(w) < 0;
    }

	public T delMin() {
		size--;
		T min = array[1];
		array[1] = array[tail--];
		sink(1);
		if(tail <= maxSize/4) resize(maxSize/2);
		return min;
	}
	
	private void sink(int pos) {
		while(2*pos <= tail) {
			int j = 2*pos;
			if(j< tail && less(array[j+1], array[j])) j++;
			if(less(array[pos], array[j])) break;
			exch(pos, j);
			pos = j;
		}
	}
	
	public int getSize() {
		return this.tail;
	}
	
	public boolean isEmpty() {
		return tail==0;
	}
	
	
}
