
public class ArrayQueue {
	private ResizingArrayStack<String> stack;
	
	public ArrayQueue() {
		stack = new ResizingArrayStack<String>();
	}
	
	public void push(String item) {
		stack.push(item);
	}
	
	public String pop() throws CloneNotSupportedException{
		ResizingArrayStack<String> dequeue = new ResizingArrayStack<String>();
		ResizingArrayStack<String> cloneStack = (ResizingArrayStack<String>) stack.clone();
		
		for(int i=0; i<cloneStack.Size(); i++) {
			dequeue.push(cloneStack.pop());
//			System.out.println(i);
//			System.out.println("cloneStack size : " + cloneStack.Size());
//			System.out.println("dequeue size : " + dequeue.Size());
		}
		
		return dequeue.pop();
	}
	
}
