
public class Singleton {
	private static Singleton singleton = new Singleton();
	
	private Singleton() {
		System.out.println("new instance is created");
	}
	
	public static Singleton getInstance() {
		System.out.println("hashcode : " + singleton.hashCode());
		return singleton;
	}
	
	public String toStirng() {
		return "Singleton";
		
	}
}
