package Main;

import implement.FixedCapacityStack;

public class MainFixtedArrayStack {

	public static void main(String[] args) {
		FixedCapacityStack<String> s;
		s = new FixedCapacityStack<String>(100);
		
		for(int i=0; i<args.length; i++) {
			if(!args[i].equals("-")) {
				s.push(args[i]);
			}
			else if(!s.isEmpty()){
				System.out.println(s.pop());
			}
		}
	
		System.out.println("\"" + s.Size() + " left on stack" + "\"");
	}

}
