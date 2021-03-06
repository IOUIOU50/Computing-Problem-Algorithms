/* HW2에서 사용했던 ListStack을 그대로 이용
 * 
 * 추가사항
 * - size 필드 추가
 * - size()메소드의 구현 부분이 복잡한 알고리즘에서
 *   size필드를 반환하는 것으로 변경*/
public class LinkedListStack implements Cloneable {
	private Node first;
	private int size;
	
	private class Node{
		String item;
		Node next;
	}
	
	public LinkedListStack() {
		 this.first = null;
		 this.size = 0;
	}

	public void push(Object item) {
		size++;
		Node oldfirst = first;
		first = new Node();
		first.item = (String)item;
		first.next = oldfirst;
	}

	public Object pop() {
		size--;
		String item = first.item;
		first = first.next;
		return item;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int Size() {
		return this.size;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
