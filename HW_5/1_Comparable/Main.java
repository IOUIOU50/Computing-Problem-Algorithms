
public class Main {

	public static void main(String[] args) {
		InsertionSort<Integer> integerSort = new InsertionSort<Integer>();
		Integer[] a = {2,1,6,4};
		integerSort.sort(a);
		integerSort.show(a);

		System.out.println();
		
		InsertionSort<Character> characterSort = new InsertionSort<Character>();
		String str = "merge";
		Character[] arrChar = new Character[str.length()];
		for(int i=0; i<str.length(); i++) {
			arrChar[i] = str.charAt(i);
		}
		characterSort.sort(arrChar);
		characterSort.show(arrChar);
	}
}
