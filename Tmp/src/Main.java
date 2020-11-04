import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.lang.Iterable;
public class Main {
	public static void main(String[] args) {
		Serializable myClass = new MyClass();
		int[] arr = new int[10];
		
		@SuppressWarnings("unused")
		ArrayList list = new ArrayList<Integer>();
		
		Comparable c = new Integer(3); //Interface pattern practive
 		
		Serializable arr2 = new ArrayList<Integer>(); //Interface pattern practive
	}
}
