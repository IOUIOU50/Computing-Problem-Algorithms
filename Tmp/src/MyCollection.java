import java.util.Iterator;

public class MyCollection<T> implements Iterable<T>{
	@Override
	public Iterator iterator() {
		return new MyIterator<T>();
	}
	
	class MyIterator<T> implements Iterator<T>{

		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public T next() {
			return null;
		}
		
	}
}
