package implement;


import java.util.Iterator;

import Interface.Stack;

public class ResizingArrayStack<Item> implements Iterable<Item>, Stack<Item> {
	private Item[] a;
	private int N;
	
	//main에서 객체 생성시 호출
	public ResizingArrayStack() {
		this.a = (Item[])new Object[1];
		this.N = 0;
	}
	
	//push에서 배열이 2/3이상 찼을시 호출
	private void resize(int max) {
		Item[] temp = (Item[])new Object[max];
		for(int i=0; i<N; i++) {
			temp[i] = a[i];
		}
		a = temp;
		System.out.println("Stack capacity has been changed. Current capacity"
				+ " is " + this.a.length);
	}
	
	//main에서 요소 삽입시 호출
	@Override
	public void push(Item item) {
		if(N >= this.a.length*0.66)
			resize(2*this.a.length);
		a[N++] = item;
	}

	//main에서 요소 반환시 호출
	@Override
	public Item pop() {
		Item item = a[--N];
		a[N] = null;
			
		if(N>0 && N==a.length/4)
			resize(a.length/2);
		
		return item;
	}

	//main에서 요소 반환시 Stack이 비어있는지 검출하기 위해 호출
	@Override
	public boolean isEmpty() {
		return false;
	}

	//main에서 pop()연산이 끝난 뒤 남은 요소가 몇개인지 알려줄 때 호출
	@Override
	public int Size() {
		return this.N;
	}

	//main에서 모든 요소를 출력할 때 호출
	@Override
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}
	
	//iterator()메소드에서 구현하는 클래스
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
}
