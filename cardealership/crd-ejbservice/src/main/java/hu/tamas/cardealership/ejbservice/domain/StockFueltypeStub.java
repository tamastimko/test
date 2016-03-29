package hu.tamas.cardealership.ejbservice.domain;

//db schema modositas kell emiatt
public enum StockFueltypeStub {
	
	PETROL("Petrol"),
	DIESEL("Diesel"),
	HYBRID("Hybrid"),
	ELECTRIC("Electric"),
	LPG("Lpg"),
	CNG("Cng");
	
	private final String label;

	private StockFueltypeStub(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
	public String getName(){
		return this.name();
	}
}
