import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

class SingletonMain{
	public static void main(String[] args) {
		System.out.println("main start");
		
		
		Singleton singleton = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();
		Singleton singleton3 = Singleton.getInstance();
		
		System.out.println(singleton);
		System.out.println(singleton2);
		System.out.println(singleton3);
	}
}