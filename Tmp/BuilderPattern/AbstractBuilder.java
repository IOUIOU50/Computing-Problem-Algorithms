
public abstract class AbstractBuilder {
	private String str = "";
	
	public AbstractBuilder append(String addStr) {
		this.str.concat(addStr);
		
		return this;
	}
}
