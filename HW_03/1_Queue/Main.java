
public class Main {
	public static void main(String[] args){
		LinkedQueue que = new LinkedQueue();
		
		que.enqueue("a");
		que.enqueue("b");
		que.enqueue("c");
		que.enqueue("d");
		que.enqueue("e");
		que.enqueue("f");
		
		System.out.println(que.dequeue());
		System.out.println(que.dequeue());
		System.out.println(que.dequeue());
		System.out.println(que.dequeue());
		
	}
}
