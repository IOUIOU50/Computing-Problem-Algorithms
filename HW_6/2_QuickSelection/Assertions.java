import java.util.Set;

public class Assertions {

	public static boolean assertEquals(Set<Integer> expected, Set<Integer> actual) {
		boolean isCorrect = expected.equals(actual);
		return isCorrect;
	}
}
