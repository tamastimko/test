package hu.tamas.cardealership.ejbservice.domain;

public enum ServiceStationProfileStub {
	
	MECHANICAL("Mechanical"),
	ELECTRICAL("Electrical"),
	EANDM("Electrical and mechanical");
	
	private final String label;

	private ServiceStationProfileStub(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
	public String getName(){
		return this.name();
	}
}
