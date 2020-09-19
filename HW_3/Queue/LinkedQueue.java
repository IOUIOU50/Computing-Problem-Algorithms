
/* 방안 1 : Push연산의 시간복잡도 O(1) / pop연산의 시간복잡도 O(n)
 * 방안 2 : Push연산의 시간복잡도 O(n) / pop연산의 시간복잡도 O(1)
 * 이 풀이에선 방안 1 선택*/

public class LinkedQueue {
	private LinkedListStack enqueue;
	
	public LinkedQueue() {
		enqueue = new LinkedListStack();
	}
	
	public void push(String item) {
		enqueue.push(item);
	}
	
	public Object pop() throws CloneNotSupportedException {
		LinkedListStack dequeue = new LinkedListStack();
		LinkedListStack cloneEnqueue = (LinkedListStack)this.enqueue.clone();
		while(!cloneEnqueue.isEmpty()) {
			dequeue.push(cloneEnqueue.pop());
		}
		
		String item = (String) dequeue.pop();
		this.enqueue = new LinkedListStack();
		
		while(!dequeue.isEmpty()) {
			enqueue.push(dequeue.pop());
		}
		
		return item;
	}
}
