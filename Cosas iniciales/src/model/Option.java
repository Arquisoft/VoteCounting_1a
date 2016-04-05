package model;

public class Option {
	private String name, preferredColor;
	
	public Option(String name, String preferredColor) {
		super();
		this.name = name;
		this.preferredColor = preferredColor;
	}
	
	public Option(String name) {
		this(name, "grey");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPreferredColor() {
		return preferredColor;
	}

	public void setPreferredColor(String preferredColor) {
		this.preferredColor = preferredColor;
	}
}
