
public class Main {
	public static void main(String[] args) {
		String inputKeys = "SEARCHEXAMPLE";
		
		SymbolTable<Character, Integer> st = new SymbolTable<Character, Integer>();
		
		/* "SEARCHEXAMPLE"과 1~12의 숫자를 각각 입력
		 * S - 1
		 * E - 2
		 * A - 3
		 * R - 4
		 * C - 5
		 * H - 6
		 * E - 7
		 * X - 8
		 * A - 9
		 * M - 10
		 * P - 11
		 * L - 12
		 * E - 13*/
		for(int i=0; i<inputKeys.length(); i++) {
			st.put(inputKeys.charAt(i), i+1);
		}
		
		System.out.println("current size : " + st.size());
		System.out.println("Key : R, Value : "+st.get('R'));
		System.out.println("Key R's rank : " + st.rank('R'));
		System.out.println("Deletes Key 'R'");
		st.delete('R');
		System.out.print("Is key 'R' in the Symbol table? : ");
		System.out.println(st.constrains('R'));
		System.out.println("current size : "+st.size());
	}
}
