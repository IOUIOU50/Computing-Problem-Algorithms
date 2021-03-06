
/* 방안 1 : Push연산의 시간복잡도 O(1) / pop연산의 시간복잡도 O(n)
 * 방안 2 : Push연산의 시간복잡도 O(n) / pop연산의 시간복잡도 O(1)
 * 이 풀이에선 방안 1 선택*/

public class LinkedQueue {
	private LinkedListStack enqueue;
	
	public LinkedQueue() {
		enqueue = new LinkedListStack();
	}
	
	public void enqueue(String item) {
		enqueue.push(item);
	}
	
	/* 알고리즘 설명
	 * 1. stack을 역으로 쌓아올리기 위한 dequeue stack 생성
	 * 2. 기존 요소가 저장된 stack을 pop하여 dequeue stack에 push
	 * 3. dequeue stack에서 pop하여 반환할 요소를 item에 저장
	 * 4. 현재 기존 요소가 저장된 stack은 pop연산으로 비어있는 상태
	 * 5. 따라서 dequeue stack에서 다시 기존 요소 스택으로 쌓아올리는 작업 필요*/
	public Object dequeue() {
		LinkedListStack dequeue = new LinkedListStack();
		while(!enqueue.isEmpty()) {
			dequeue.push(enqueue.pop());
		}
		
		String item = (String) dequeue.pop();
		
		while(!dequeue.isEmpty()) {
			enqueue.push(dequeue.pop());
		}
		
		return item;
	}
}
