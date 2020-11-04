
public class BuilderClient {
	//client means Director
	
	Factory factory = new Factory();

	AbstractBuilder builder = factory.getBuilder("String");

}
