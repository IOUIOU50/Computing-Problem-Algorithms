package Main;

import implement.ListStack;

public class MainListStack {
	public static void main(String[] args) {
		ListStack st = new ListStack();
		
		for(int i=0; i<args.length; i++) {
			if(!args[i].equals("-")) {
				st.push(args[i]);
			}
			else if(!st.isEmpty()){
				System.out.println(st.pop());
			}
		}
		
		System.out.println(st.Size() + " left on stack");
	}
}
