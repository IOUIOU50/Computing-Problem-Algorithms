
public class Main {
	public static void main(String[] args) throws CloneNotSupportedException {
		LinkedQueue que = new LinkedQueue();
		
		que.push("a");
		que.push("b");
		que.push("c");
		que.push("d");
		que.push("e");
		que.push("f");
		
		System.out.println(que.pop());
		System.out.println(que.pop());
		System.out.println(que.pop());
		System.out.println(que.pop());
		
	}
}
