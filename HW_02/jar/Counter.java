public  class Counter {
	private String id;
	private int count;
	
	public Counter() {
		this("counter" ,0);
	}
	
	public Counter(int initValue) {
		this("counter", initValue);
	}
	
	public Counter(String id) {
		this(id, 0);
	}
	
	public Counter(String id, int initValue) {
		this.id = id;
		this.count = initValue;
	}
	
	public void increment() {
		this.count++;
	}
	
	public int tally() {
		return count;
	}
	
	public String toString() {
		return Integer.toString(count) + " " + id;
	}
}
