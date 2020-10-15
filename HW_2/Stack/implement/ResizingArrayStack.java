package implement;


import java.util.Iterator;

import Interface.Stack;

public class ResizingArrayStack<Item> implements Iterable<Item>, Stack<Item> {
	private Item[] a;
	private int N;
	
	//main���� ��ü ������ ȣ��
	public ResizingArrayStack() {
		this.a = (Item[])new Object[1];
		this.N = 0;
	}
	
	//push���� �迭�� 2/3�̻� á���� ȣ��
	private void resize(int max) {
		Item[] temp = (Item[])new Object[max];
		for(int i=0; i<N; i++) {
			temp[i] = a[i];
		}
		a = temp;
		System.out.println("Stack capacity has been changed. Current capacity"
				+ " is " + this.a.length);
	}
	
	//main���� ��� ���Խ� ȣ��
	@Override
	public void push(Item item) {
		if(N >= this.a.length*0.66)
			resize(2*this.a.length);
		a[N++] = item;
	}

	//main���� ��� ��ȯ�� ȣ��
	@Override
	public Item pop() {
		Item item = a[--N];
		a[N] = null;
			
		if(N>0 && N==a.length/4)
			 ;
		
		return item;
	}

	//main���� ��� ��ȯ�� Stack�� ����ִ��� �����ϱ� ���� ȣ��
	@Override
	public boolean isEmpty() {
		return false;
	}

	//main���� pop()������ ���� �� ���� ��Ұ� ����� �˷��� �� ȣ��
	@Override
	public int Size() {
		return this.N;
	}

	//main���� ��� ��Ҹ� ����� �� ȣ��
	@Override
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}
	
	//iterator()�޼ҵ忡�� �����ϴ� Ŭ����
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
