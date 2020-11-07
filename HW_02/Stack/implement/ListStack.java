package implement;

import Interface.Stack;

public class ListStack implements Stack{
	private Node first;
	
	private class Node{
		String item;
		Node next;
	}
	
	public ListStack() {
		 this.first = null;
	}

	@Override
	public void push(Object item) {
		// TODO Auto-generated method stub
		Node oldfirst = first;
		first = new Node();
		first.item = (String)item;
		first.next = oldfirst;
	}

	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		String item = first.item;
		first = first.next;
		return item;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return first == null;
	}

	//LinkedList�� �̿��� Stack���� Size�� ���ϱ� ���� �޼ҵ�
	@Override
	public int Size() {
		// TODO Auto-generated method stub
		/* ���� ������ �����ϱ� ������ ���� ��嵵 ī��Ʈ�� �����ؾ� �Ѵ�.
		 * ���� cnt���� 0�̾ƴ϶� 1���� �����ؾ��Ѵ�.*/
		int cnt = 1;  
		Node iter = first.next;
		while(!(iter == null)) {
			iter = first.next.next;
			cnt++;
		}
		
		return cnt;
	}
}
