
import java.util.Iterator;


public class ResizingArrayStack<Item> implements Iterable<Item>, Cloneable{
	private Item[] a;
	private int N;
	
	public ResizingArrayStack() {
		this.a = (Item[])new Object[1];
		this.N = 0;
	}
	
	private void resize(int max) {
		Item[] temp = (Item[])new Object[max];
		for(int i=0; i<N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}
	
	public void push(Item item) {
		if(N >= this.a.length*0.66)
			resize(2*this.a.length);
		a[N++] = item;
	}

	public Item pop() {
		Item item = a[--N];
		a[N] = null;
			
		if(N>0 && N==a.length/4)
			resize(a.length/2);
		
		return item;
	}

	public boolean isEmpty() {
		return false;
	}

	public int Size() {
		return this.N;
	}

	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item>{
		private int i = N;

		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public Item next() {
			return a[--i];
		}
		
		public void remove() {}
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
