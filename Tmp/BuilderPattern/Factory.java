
public class Factory {
	// This class creates builder
	public AbstractBuilder getBuilder(String type) {
		if(type.equals("String"));
			return new MyStringBuilder();
	}

}
