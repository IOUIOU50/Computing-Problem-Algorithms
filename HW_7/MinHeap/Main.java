import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		String input = "ENISGPHTORA"; //11 letters
		
		MinHeap<Character> heap = new MinHeap<Character>();

		for(int i=0; i<input.length(); i++) {
			heap.insert(input.charAt(i));
		}
		
		ArrayList output = new ArrayList<Character>();
		
		while(!heap.isEmpty()) {
			output.add(heap.delMin());
			System.out.println(output);
		}

		
	}
}
