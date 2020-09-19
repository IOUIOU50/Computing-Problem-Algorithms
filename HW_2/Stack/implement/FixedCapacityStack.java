package implement;

import Interface.Stack;

public class FixedCapacityStack<Item> implements Stack<Item>{
	private Item[] a;
	private int N;
	
	public FixedCapacityStack(int cap) {
		a = (Item[]) new Object[cap];
	}
	
	@Override
	public void push(Item item) {
		a[N++] = item;
	}

	@Override
	public Item pop() {
		return a[--N];
	}

	@Override
	public boolean isEmpty() {
		return N == 0;
	}

	@Override
	public int Size() {
		return N;
	}

	public boolean isFull() {
		return N+1 == a.length;
	}
}

