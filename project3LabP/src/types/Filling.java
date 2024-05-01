package types;


public enum Filling {
	SMILE("😃"),
	SAD("😒"),
	FURIOUS("😡"),
	ANGEL("😇"),
	BLIINK("😉"),
	EVIL("😈"),
	SUN("😎"),
	LOVE("😍");
	
	
	private String rep;
	
	Filling(String s) {
		this.rep = s;
	}

	public String toString() {
		return this.rep;
	}

	public Filling[] fillings() {
		return Filling.values();
	}

}
