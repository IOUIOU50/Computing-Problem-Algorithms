import java.util.Iterator;

public class SymbolTable<Key extends Comparable<Key>, Value>{
	private Key[] keys; //key 배열
	private Value[] vals; //value 배열
	private int N; //심볼테이블의 크기
	
	public SymbolTable() {
		this.keys = (Key[])new Comparable[1]; //keys는 comparable을 거쳐와야함
		this.vals = (Value[])new Object[1]; 
		this.N = 0;
	}
	
	//put()에서 설명
    private void exch(int i, int j) {
        Key swapKey = keys[i];
        keys[i] = keys[j];
        keys[j] = swapKey;
        
        Value swapValue = vals[i];
        vals[i] = vals[j];
        vals[j] = swapValue;
    }
	
    //배열의 단점을 보완하기 위한 resize정책
	private void resize(int maxSize) {
		Key[] newKeys = (Key[])new Comparable[maxSize];
		Value[] newVals= (Value[])new Object[maxSize];
		
		for(int i=0; i<N; i++) {
			newKeys[i] = keys[i];
			newVals[i] = vals[i];
		}
		
		keys = newKeys;
		vals = newVals;
		
		System.out.println("SymbolTable capacity has been changed. "
				+ "Current capacity"+ " is " + this.keys.length);

	}
	
	/* 
	 * 고안한 알고리즘
	 * 1. key, value배열 각각의 끝에 삽입한다.
	 * 2. rank()를 통해 들어갈 위치를 찾는다
	 * 3. 위치를 찾으면, 해당 위치까지 배열의 끝에서부터 교환을 수행한다.(버블정렬과 유사)
	 * [기존] [기존] [기존] [기존, 들어갈자리] [기존] [기존] [새로삽입]
	 *                                        └  교환     ┘
	 * [기존] [기존] [기존] [기존, 들어갈자리] [기존] [새로삽입] [기존]
	 * ...(반복)...                                       
	 * */
	public void put(Key key, Value val) {
		if(N == keys.length) resize(keys.length * 2);
		
		keys[N] = key;
		vals[N] = val;
		N++;
		
		int index = rank(key);
		for(int i=N-1; i>index; i--) {
			exch(i, i-1);
		}
	}
	
	public Value get(Key key) {
		if(isEmpty()) return null;
		int i = rank(key);
		if(i < N && keys[i].compareTo(key)==0) return vals[i];
		else return null;
	}
	
	/* 
	 * put()알고리즘과 유사하게
	 * 해당 원소를 삭제하고 나면
	 * 그 자리 뒤의 원소들을 전부 앞으로 당겨오는 과정을
	 * 버블정렬처럼 수행한다.
	 * */
	public void delete(Key key) {
		if(isEmpty()) return;
		int i = rank(key);
		for(int j=i; j<N; j++) {
			exch(j, j+1);
		}
		N--;
		
		if(N<=keys.length/4) resize(keys.length/4);

	}
	
	public boolean constrains(Key key) {
		int index = rank(key);
		if(keys[index] == key) return true;
		else return false;
	}
	
	public boolean isEmpty() {
		return N==0;
	}
	
	public int size() {
		return N;
	}
	
	//이미 정렬되어있는 상태이기 때문에 0번째 인덱스가 최소키
	public Key minKey() {
		if(!isEmpty())
			return keys[0];
		else
			return null;
	}
	
	//이미 정렬되어있는 상태이기 때문에 N-1번째 인덱스가 최대키
	public Key maxKey() {
		if(!isEmpty())
			return keys[N-1];
		else
			return null;	
	}
	
	public int rank(Key key) {
		int lo = 0, hi = N-1;
		while(lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(keys[mid]);
			if(cmp<0) hi = mid - 1;
			else if(cmp>0) lo = mid + 1;
			else return mid;
		}
		return lo;
	}
	
	public Key select(int k) {
		if(!isEmpty())
			return keys[k];
		else
			return null;
	}
	
	public void deleteMin() {
		if(!isEmpty())
			delete(keys[0]);
	}
	
	public void deleteMax() {
		if(!isEmpty())
			delete(keys[N-1]);
	}
	
	public int size(Key lo, Key hi) {
		if(!isEmpty()) {
			int loKey = rank(lo);
			int hiKey = rank(hi);
			
			return hiKey - loKey + 1;
		}
		else return 0;
	}
	
	private class KeyIterator implements Iterable<Key>{

		@Override
		public Iterator<Key> iterator() {
			return null;
		}
		
	}
	/* Iterable과 Iterator를 구현하려 했으나 실패했습니다...*/
//	public Iterable<Key> keys(Key lo, Key hi){
//		return new SymbolTableIterator(lo, hi);
//
//	}
//	
//	public Iterable<Key> keys(){
//		return null;
//		
//	}
//	
//	private class SymbolTableIterator implements Iterable<Key>{
//		private int loKeyIndex;
//		private int hiKeyIndex;
//		private int i;
//
//		public SymbolTableIterator() {
//			this(keys[0], keys[N-1]);
//		}
//		
//		public SymbolTableIterator(Key lo, Key hi) {
//			loKeyIndex = rank(lo);
//			hiKeyIndex = rank(hi);
//			i = loKeyIndex;
//		}
//
//		@Override
//		public Iterator<Key> iterator() {
//			return null;
//		}
//
//		
//	}

}
