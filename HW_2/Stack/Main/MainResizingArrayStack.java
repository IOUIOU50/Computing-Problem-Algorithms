package Main;

import java.util.Iterator;

import implement.ResizingArrayStack;

public class MainResizingArrayStack {
	public static void main(String[] args) {
		ResizingArrayStack<String> s;
		s = new ResizingArrayStack<String>();
		
		for(int i=0; i<args.length; i++) {
			if(!args[i].equals("-")) {
				s.push(args[i]);
				System.out.println("push "+"\'" + args[i] + "\'");
			}
			else if(!s.isEmpty()){
				System.out.println("\'" + s.pop() + "\' is popped");
				System.out.println("\"" + s.Size() + " left on stack" + "\"");
			}
			System.out.println("Current Stack(The left one comes out first)");
			System.out.print("[");
			for(Iterator<String> arrayIter=s.iterator(); arrayIter.hasNext();) {
				System.out.print(arrayIter.next() + ", ");
			}
			System.out.println("]");
			System.out.println("**********************************************");	
		}
	
	}
}
