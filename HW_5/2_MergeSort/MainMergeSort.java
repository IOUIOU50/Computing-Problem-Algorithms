
public class MainMergeSort {
	public static void main(String[] args) {
		String str = "MERGESORTEXAMPLE";
		
		Character[] arrMerge = new Character[str.length()];
		
		for(int i=0; i<str.length(); i++) {
			arrMerge[i] = str.charAt(i);
		}
		
		MergeSort.sort(arrMerge);
		MergeSort.show(arrMerge);
	}
}
