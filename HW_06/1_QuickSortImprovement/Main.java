
public class Main {
	public static void main(String[] args) {
		String str = "ABCDEFGHIJKLMNO"; //14 letters
		Character[] quick = new Character[str.length()];
		
		
		for(int i=0; i<str.length(); i++) {
			quick[i] = str.charAt(i);
		}

		
		QuickSort<Character> sort = new QuickSort<Character>();
		sort.shuffle(quick);
		System.out.print("Init array : "); sort.show(quick); System.out.println();
		
		Character[] usingInsertion = quick.clone();
		Character[] usingMedian = quick.clone();
		
		//normal quick sort
		sort.sort(quick, 0, quick.length-1);
		System.out.println("this is normal quick sort: ");
		sort.show(quick);
		System.out.println();
		
		//using Insertion and CUTOFF
		sort.sortUsingInsertion(usingInsertion, 0, usingInsertion.length-1);
		System.out.println("this is quick sort using insertion sort and Cutoff: ");
		sort.show(usingInsertion);
		System.out.println();
		
		//using Median
		sort.sortUsingMedian(usingMedian, 0, usingMedian.length-1);
		System.out.println("this is quick sort usung median : ");
		sort.show(usingMedian);
		
	}
}
